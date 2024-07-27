package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payer {
    private String payerId;
    private String firstName;
    private String lastName;
    private String email;
    private BillingAddress billingAddress;
}
