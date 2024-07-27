package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayerDto {
    private String payerId;
    private String firstName;
    private String lastName;
    private String email;
    private BillingAddressDto billingAddress;
}
