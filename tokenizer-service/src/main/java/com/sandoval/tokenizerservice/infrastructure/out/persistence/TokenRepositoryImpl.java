package com.sandoval.tokenizerservice.infrastructure.out.persistence;

import com.sandoval.tokenizerservice.infrastructure.out.persistence.model.TokenModel;
import com.sandoval.tokenizerservice.infrastructure.out.persistence.model.mapper.TokenModelMapper;
import com.sandoval.tokenizerservice.application.port.out.TokenRepository;
import com.sandoval.tokenizerservice.domain.model.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private final TokenJpaRepository tokenJpaRepository;

    @Override
    public Token save(Token token) {
        TokenModel tokenModel = TokenModelMapper.INSTANCE.toTokenModel(token);
        return TokenModelMapper.INSTANCE.toToken(tokenJpaRepository.save(tokenModel));
    }

    @Override
    public Token findByToken(String token) {
        return TokenModelMapper.INSTANCE.toToken(tokenJpaRepository.findByToken(token));
    }
}
