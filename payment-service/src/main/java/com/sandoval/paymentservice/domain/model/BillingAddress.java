package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingAddress {

    private String billingAddressId;
    private String street;
    private String city;
    private String country;
}
