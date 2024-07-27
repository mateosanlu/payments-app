package com.sandoval.paymentservice.application.port.out;

import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.TokenResponse;

public interface TokenizationClient {

    TokenResponse tokenize(TokenRequest request);
}
