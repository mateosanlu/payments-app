package com.sandoval.paymentservice.domain.service;

import com.sandoval.paymentservice.application.dto.mapper.BankMapper;
import com.sandoval.paymentservice.application.port.in.BankService;
import com.sandoval.paymentservice.application.port.out.BankClient;
import com.sandoval.paymentservice.domain.model.BankRequest;
import com.sandoval.paymentservice.domain.model.BankResponse;
import com.sandoval.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankClient bankClient;

    @Override
    public BankResponse processBankTransaction(Payment payment) {

        BankRequest bankRequest = BankRequest.builder()
                .transactionId(payment.getTransactionId())
                .cardToken(payment.getCreditCard().getCardToken())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .build();

        return BankMapper.INSTANCE.toDomain(
                bankClient.processPayment(BankMapper.INSTANCE.toDto(bankRequest))
        );
    }
}
