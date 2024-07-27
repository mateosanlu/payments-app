package com.sandoval.tokenizerservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDto {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
