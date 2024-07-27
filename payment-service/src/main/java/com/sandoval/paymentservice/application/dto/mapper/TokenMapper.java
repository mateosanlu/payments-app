package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.TokenResponse;
import com.sandoval.paymentservice.domain.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TokenMapper {

    TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);

    @Mapping(source = "token", target = "cardToken")
    @Mapping(source = "maskedCardNumber", target = "cardNumber")
    CreditCard toCreditCard(TokenResponse tokenResponse);


    TokenRequest toTokenRequest(CreditCard creditCard);

}
