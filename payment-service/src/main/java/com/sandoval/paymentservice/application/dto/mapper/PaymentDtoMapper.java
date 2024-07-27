package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.PaymentRequestDto;
import com.sandoval.paymentservice.application.dto.TransactionResponseDto;
import com.sandoval.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentDtoMapper {

    PaymentDtoMapper INSTANCE = Mappers.getMapper(PaymentDtoMapper.class);

    Payment toDomain(PaymentRequestDto paymentDto);

    TransactionResponseDto toPaymentResponseDto(Payment payment);
}
