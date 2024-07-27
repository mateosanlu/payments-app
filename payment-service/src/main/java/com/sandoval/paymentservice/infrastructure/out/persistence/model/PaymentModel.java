package com.sandoval.paymentservice.infrastructure.out.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_Id")
    private OrderModel order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id", referencedColumnName = "payer_Id")
    private PayerModel payer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id", referencedColumnName = "card_id")
    private CreditCardModel creditCard;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private String status;

    @Column(name = "message")
    private String message;
}
