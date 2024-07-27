package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.*;
import com.sandoval.paymentservice.domain.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankMapper {

    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    BankRequest toDomain(BankRequestDto bankRequestDto);

    BankRequestDto toDto(BankRequest bankRequest);

    BankResponse toDomain(BankResponseDto bankResponseDto);

    BankResponseDto toDto(BankResponse bankResponse);

}
