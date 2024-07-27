package com.sandoval.paymentservice.domain.service;

import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.TokenResponse;
import com.sandoval.paymentservice.application.port.out.TokenizationClient;
import com.sandoval.paymentservice.domain.model.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TokenizationServiceImplTest {

    @Mock
    private TokenizationClient tokenizationClient;

    @InjectMocks
    private TokenizationServiceImpl tokenizationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void tokenizeCreditCard_ShouldReturnTokenizedCreditCard() {
        // Arrange
        CreditCard creditCard = CreditCard.builder()
                .cardNumber("1234567812345678")
                .expiryDate("12/24")
                .cvv("123")
                .build();

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setMaskedCardNumber("**** **** **** 5678");

        when(tokenizationClient.tokenize(any(TokenRequest.class))).thenReturn(tokenResponse);

        // Act
        CreditCard result = tokenizationService.tokenizeCreditCard(creditCard);

        // Assert
        assertEquals(tokenResponse.getMaskedCardNumber(), result.getCardNumber());
    }
}