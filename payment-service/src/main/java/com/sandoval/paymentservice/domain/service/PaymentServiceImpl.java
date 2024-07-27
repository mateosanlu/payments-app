package com.sandoval.paymentservice.domain.service;

import com.sandoval.paymentservice.application.dto.PaymentRequestDto;
import com.sandoval.paymentservice.application.dto.TransactionResponseDto;
import com.sandoval.paymentservice.application.dto.mapper.PaymentDtoMapper;
import com.sandoval.paymentservice.application.port.in.AntiFraudService;
import com.sandoval.paymentservice.application.port.in.BankService;
import com.sandoval.paymentservice.application.port.in.PaymentService;
import com.sandoval.paymentservice.application.port.in.TokenizationService;
import com.sandoval.paymentservice.application.port.out.PaymentRepository;
import com.sandoval.paymentservice.domain.model.BankResponse;
import com.sandoval.paymentservice.domain.model.Payment;
import com.sandoval.paymentservice.exception.PaymentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final TokenizationService tokenizationService;
    private final AntiFraudService antiFraudService;
    private final BankService bankService;

    @Override
    public TransactionResponseDto savePayment(PaymentRequestDto paymentRequestDto) {
        Payment payment = initializePayment(paymentRequestDto);
        log.info("Processing payment: {}", payment);

        tokenizeCreditCard(payment);
        savePendingPayment(payment);

        if (antiFraudService.isFraudulent(payment)) {
            handleFraudulentPayment(payment);
            return createResponse(payment);
        }

        Payment paymentProcessed = processBankTransaction(payment);
        return createResponse(paymentRepository.save(paymentProcessed));
    }

    @Override
    public TransactionResponseDto getPayment(String transactionId) {

        return PaymentDtoMapper.INSTANCE.toPaymentResponseDto(getPaymentByTransactionId(transactionId));
    }

    @Override
    public TransactionResponseDto processRefund(String transactionId) {

        Payment payment = getPaymentByTransactionId(transactionId);
        Payment paymentRefunded = processBankRefund(payment);

        return createResponse(paymentRepository.save(paymentRefunded));
    }

    private Payment getPaymentByTransactionId(String transactionId) {
        Payment payment = paymentRepository.findByTransactionId(transactionId);

        if (isNull(payment)) {
            log.info("Transaction not found: " + transactionId);
            throw new PaymentNotFoundException(transactionId);
        }
        return payment;
    }

    private Payment initializePayment(PaymentRequestDto paymentRequestDto) {
        Payment payment = PaymentDtoMapper.INSTANCE.toDomain(paymentRequestDto);
        if (payment.getTransactionId() == null) {
            payment.setTransactionId(UUID.randomUUID().toString());
        }
        payment.setStatus("PENDING");
        payment.setDate(LocalDateTime.now());
        payment.setType("SALE");
        return payment;
    }

    private void tokenizeCreditCard(Payment payment) {
        payment.setCreditCard(tokenizationService.tokenizeCreditCard(payment.getCreditCard()));
    }

    private void savePendingPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    private void handleFraudulentPayment(Payment payment) {
        log.warn("Payment flagged as fraudulent: {}", payment);
        payment.setStatus("REJECTED");
        payment.setMessage("Payment rejected due to fraud detection");
        paymentRepository.save(payment);
    }

    private Payment processBankTransaction(Payment payment) {
        BankResponse bankResponse = bankService.processBankTransaction(payment);
        log.info("Bank response: {}", bankResponse);

        if (bankResponse.getStatus().equals("SUCCESS")) {
            payment.setStatus("APPROVED");
            payment.setMessage("Payment completed successfully");
        } else {
            payment.setStatus("REJECTED");
            payment.setMessage("Payment rejected by bank: " + bankResponse.getMessage());
        }

        return payment;
    }

    private TransactionResponseDto createResponse(Payment payment) {
        return PaymentDtoMapper.INSTANCE.toPaymentResponseDto(payment);
    }

    private Payment processBankRefund(Payment payment) {
        BankResponse bankResponse = bankService.processBankTransaction(payment);
        log.info("Bank response for refund: {}", bankResponse);

        if (bankResponse.getStatus().equals("SUCCESS")) {
            payment.setStatus("REFUNDED");
            payment.setMessage("Refund completed successfully");
        } else {
            payment.setStatus("REFUND_FAILED");
            payment.setMessage("Refund failed: " + bankResponse.getMessage());
        }

        return payment;
    }
}
