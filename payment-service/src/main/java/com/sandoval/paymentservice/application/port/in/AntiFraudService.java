package com.sandoval.paymentservice.application.port.in;

import com.sandoval.paymentservice.domain.model.Payment;

public interface AntiFraudService {

    boolean isFraudulent(Payment payment);
}
