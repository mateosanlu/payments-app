package com.sandoval.tokenizerservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.tokenizerservice.infrastructure.out.persistence.model.TokenModel;
import com.sandoval.tokenizerservice.domain.model.Token;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TokenModelMapper {

    TokenModelMapper INSTANCE = Mappers.getMapper(TokenModelMapper.class);

    TokenModel  toTokenModel(Token token);

    @InheritInverseConfiguration
    Token toToken(TokenModel tokenModel);
}
