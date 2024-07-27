package com.sandoval.paymentservice.application.port.in;

import com.sandoval.paymentservice.domain.model.BankResponse;
import com.sandoval.paymentservice.domain.model.Payment;

public interface BankService {
    BankResponse processBankTransaction(Payment payment);
}
