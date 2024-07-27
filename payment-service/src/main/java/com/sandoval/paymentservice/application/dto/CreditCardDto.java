package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardDto {
    private String cardId;
    private String cardToken;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
