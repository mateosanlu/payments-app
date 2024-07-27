package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.PayerDto;
import com.sandoval.paymentservice.domain.model.Payer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayerDtoMapper {

    PayerDtoMapper INSTANCE = Mappers.getMapper(PayerDtoMapper.class);

    PayerDto toPayerDto(Payer payer);

    Payer toPayer(PayerDto payerDto);
}
