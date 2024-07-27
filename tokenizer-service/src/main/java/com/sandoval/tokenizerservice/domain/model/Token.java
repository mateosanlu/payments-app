package com.sandoval.tokenizerservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String token;
    private String maskedCardNumber;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

}
