package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestDto {

    private OrderDto order;
    private PayerDto payer;
    private CreditCardDto creditCard;
    private double amount;
    private String currency;
    private String message;
}
