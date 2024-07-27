package com.sandoval.tokenizerservice.domain.service;

import com.sandoval.tokenizerservice.application.port.in.TokenizationService;
import com.sandoval.tokenizerservice.application.port.out.TokenRepository;
import com.sandoval.tokenizerservice.domain.model.Card;
import com.sandoval.tokenizerservice.domain.model.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenizationServiceImpl implements TokenizationService {

    private final TokenRepository tokenRepository;

    @Override
    public Token tokenizeCard(Card card) {

        String tokenValue = generateToken(card.getCardNumber(), card.getExpiryDate(), card.getCvv());
        String maskedCardNumber = maskCardNumber(card.getCardNumber());

        Token existingToken = tokenRepository.findByToken(tokenValue);
        if (existingToken == null) {
            Token newToken = Token.builder()
                    .token(tokenValue)
                    .maskedCardNumber(maskedCardNumber)
                    .cardNumber(card.getCardNumber())
                    .expiryDate(card.getExpiryDate())
                    .cvv(card.getCvv())
                    .build();
            existingToken = tokenRepository.save(newToken);
        }
        return existingToken;
    }

    private String generateToken(String cardNumber, String expiryDate, String cvv) {
        return Integer.toHexString(cardNumber.hashCode());
    }

    private String maskCardNumber(String cardNumber) {
        //return cardNumber.replaceAll("\\d(?=\\d{4})", "*");
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
