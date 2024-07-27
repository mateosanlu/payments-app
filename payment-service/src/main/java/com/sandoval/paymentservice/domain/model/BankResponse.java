package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankResponse {

    private String transactionId;
    private String status;
    private String message;
}
