package com.sandoval.paymentservice.infrastructure.out.external.tokenization;

import com.sandoval.paymentservice.application.port.out.TokenizationClient;
import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenizationClientImpl implements TokenizationClient {

    private final TokenizationFeignClient tokenizationFeignClient;

    @Override
    public TokenResponse tokenize(TokenRequest request) {
        return tokenizationFeignClient.tokenize(request);
    }
}
