package com.sandoval.paymentservice.infrastructure.out.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "billing_addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "billing_address_id")
    private String billingAddressId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}
