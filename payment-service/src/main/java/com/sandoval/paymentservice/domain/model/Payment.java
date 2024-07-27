package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Payment {

    private String transactionId;
    private LocalDateTime date;
    private Order order;
    private Payer payer;
    private CreditCard creditCard;
    private String type;
    private double amount;
    private String currency;
    private String status;
    private String message;
}
