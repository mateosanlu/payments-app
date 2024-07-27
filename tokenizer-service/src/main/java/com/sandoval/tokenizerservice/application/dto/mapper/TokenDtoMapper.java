package com.sandoval.tokenizerservice.application.dto.mapper;

import com.sandoval.tokenizerservice.application.dto.TokenDto;
import com.sandoval.tokenizerservice.domain.model.Token;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TokenDtoMapper {

    TokenDtoMapper INSTANCE = Mappers.getMapper(TokenDtoMapper.class);

    TokenDto toTokenDto(Token token);

}
