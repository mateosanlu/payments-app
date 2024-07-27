package com.sandoval.paymentservice.domain.service;

import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.mapper.TokenMapper;
import com.sandoval.paymentservice.application.port.in.TokenizationService;
import com.sandoval.paymentservice.application.port.out.TokenizationClient;
import com.sandoval.paymentservice.domain.model.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenizationServiceImpl implements TokenizationService {

    private final TokenizationClient tokenizationClient;

    @Override
    public CreditCard tokenizeCreditCard(CreditCard creditCard) {

        TokenRequest tokenRequest = TokenMapper.INSTANCE.toTokenRequest(creditCard);
        return TokenMapper.INSTANCE.toCreditCard(tokenizationClient.tokenize(tokenRequest));
    }
}
