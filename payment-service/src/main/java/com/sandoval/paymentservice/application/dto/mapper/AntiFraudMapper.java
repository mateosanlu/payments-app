package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.AntiFraudRequestDto;
import com.sandoval.paymentservice.application.dto.AntiFraudResponseDto;
import com.sandoval.paymentservice.domain.model.AntiFraudRequest;
import com.sandoval.paymentservice.domain.model.AntiFraudResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AntiFraudMapper {

    AntiFraudMapper INSTANCE = Mappers.getMapper(AntiFraudMapper.class);

    AntiFraudRequestDto toDto(AntiFraudRequest antiFraudRequest);

    AntiFraudResponse toDomain(AntiFraudResponseDto antiFraudResponseDto);

}
