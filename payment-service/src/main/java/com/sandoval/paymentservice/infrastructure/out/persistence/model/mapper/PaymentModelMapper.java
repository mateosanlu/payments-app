package com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.PaymentModel;
import com.sandoval.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentModelMapper {

    PaymentModelMapper INSTANCE = Mappers.getMapper(PaymentModelMapper.class);

    PaymentModel toPaymentModel(Payment payment);

    Payment toPayment(PaymentModel paymentModel);
}
