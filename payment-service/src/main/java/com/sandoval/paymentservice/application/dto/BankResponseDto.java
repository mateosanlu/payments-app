package com.sandoval.paymentservice.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDto {

    private String transactionId;
    private String status;
    private String message;
}
