package com.sandoval.paymentservice.infrastructure.out.persistence.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payer_id")
    private String payerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "billing_address_id")
    private BillingAddressModel billingAddress;
}
