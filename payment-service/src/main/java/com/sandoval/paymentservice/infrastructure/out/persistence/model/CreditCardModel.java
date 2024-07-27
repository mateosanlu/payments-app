package com.sandoval.paymentservice.infrastructure.out.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_cards")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_id")
    private String cardId;

    @Column(name = "card_token")
    private String cardToken;

    @Column(name = "card_number")
    private String cardNumber;
//
//    @Column(name = "expiry_date")
//    private String expiryDate;
//
//    @Column(name = "cvv")
//    private String cvv;
}
