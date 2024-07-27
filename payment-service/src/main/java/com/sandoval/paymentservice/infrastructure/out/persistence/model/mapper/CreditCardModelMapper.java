package com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.CreditCardModel;
import com.sandoval.paymentservice.domain.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditCardModelMapper {

    CreditCardModelMapper INSTANCE = Mappers.getMapper(CreditCardModelMapper.class);

    CreditCardModel toCreditCardModel(CreditCard creditCard);

    CreditCard toCreditCard(CreditCardModel creditCardModel);
}
