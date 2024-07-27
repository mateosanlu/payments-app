package com.sandoval.paymentservice.application.port.out;

import com.sandoval.paymentservice.domain.model.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);
    Payment findByTransactionId(String transactionId);
}
