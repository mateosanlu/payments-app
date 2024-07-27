package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankRequest {

    private String transactionId;
    private String cardToken;
    private double amount;
    private String currency;
}
