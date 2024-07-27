package com.sandoval.paymentservice.application.port.in;

import com.sandoval.paymentservice.domain.model.CreditCard;

public interface TokenizationService {

    CreditCard tokenizeCreditCard(CreditCard creditCard);
}
