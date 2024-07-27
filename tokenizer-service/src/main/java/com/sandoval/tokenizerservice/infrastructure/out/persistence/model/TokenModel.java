package com.sandoval.tokenizerservice.infrastructure.out.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tokens")
public class TokenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="token_id")
    private String tokenId;

    @Column(name = "token")
    private String token;

    @Column(name = "masked_card_number")
    private String maskedCardNumber;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "cvv")
    private String cvv;

}
