package com.sandoval.paymentservice.application.port.in;

import com.sandoval.paymentservice.application.dto.PaymentRequestDto;
import com.sandoval.paymentservice.application.dto.TransactionResponseDto;

public interface PaymentService {

    TransactionResponseDto savePayment(PaymentRequestDto paymentRequestDto);

    TransactionResponseDto getPayment(String transactionId);

    TransactionResponseDto processRefund(String transactionId);
}
