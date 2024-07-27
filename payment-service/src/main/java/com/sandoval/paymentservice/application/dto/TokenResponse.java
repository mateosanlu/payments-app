package com.sandoval.paymentservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    private String token;
    private String maskedCardNumber;
}
