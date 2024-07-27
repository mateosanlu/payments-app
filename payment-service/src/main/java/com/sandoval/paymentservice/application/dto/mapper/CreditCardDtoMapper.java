package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.CreditCardDto;
import com.sandoval.paymentservice.domain.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditCardDtoMapper {

    CreditCardDtoMapper INSTANCE = Mappers.getMapper(CreditCardDtoMapper.class);

    CreditCardDto toCreditCardDto(CreditCard creditCard);

    CreditCard toCreditCard(CreditCardDto creditCardDto);
}
