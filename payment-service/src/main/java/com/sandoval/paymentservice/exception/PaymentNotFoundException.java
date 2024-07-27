package com.sandoval.paymentservice.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String id) {
        super("Transaction not found: " + id);
    }
}
