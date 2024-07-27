package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AntiFraudRequest {

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
