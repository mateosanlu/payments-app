package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponseDto {
    private String transactionId;
    private LocalDateTime date;
    private double amount;
    private String currency;
    private String status;
    private String message;
}
