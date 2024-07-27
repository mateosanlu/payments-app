package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Refund {

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
