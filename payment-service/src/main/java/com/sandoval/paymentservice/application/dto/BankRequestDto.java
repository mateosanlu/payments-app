package com.sandoval.paymentservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankRequestDto {

    private String transactionId;
    private String cardToken;
    private double amount;
    private String currency;
}
