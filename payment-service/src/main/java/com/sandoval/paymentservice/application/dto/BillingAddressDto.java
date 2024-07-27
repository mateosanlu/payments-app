package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingAddressDto {
    private String billingAddressId;
    private String street;
    private String city;
    private String country;
}
