package com.sandoval.tokenizerservice.application.dto.mapper;

import com.sandoval.tokenizerservice.application.dto.CardDto;
import com.sandoval.tokenizerservice.domain.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardDtoMapper {

    CardDtoMapper INSTANCE = Mappers.getMapper(CardDtoMapper.class);

    Card toCard(CardDto cardDto);
}
