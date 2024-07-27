package com.sandoval.tokenizerservice.application.port.in;

import com.sandoval.tokenizerservice.domain.model.Card;
import com.sandoval.tokenizerservice.domain.model.Token;

public interface TokenizationService {

    Token tokenizeCard(Card card);
}
