package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AntiFraudRequestDto {

    private String cardToken;
    private double amount;
    private String currency;
    private String cardNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private String country;
}
