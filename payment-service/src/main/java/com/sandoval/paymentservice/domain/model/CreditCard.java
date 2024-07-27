package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCard {
    private String cardId;
    private String cardToken;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
