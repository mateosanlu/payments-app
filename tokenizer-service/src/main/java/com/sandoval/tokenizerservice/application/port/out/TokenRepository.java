package com.sandoval.tokenizerservice.application.port.out;

import com.sandoval.tokenizerservice.domain.model.Token;

import java.util.Optional;

public interface TokenRepository {

    Token findByToken(String token);
    Token save(Token token);
}
