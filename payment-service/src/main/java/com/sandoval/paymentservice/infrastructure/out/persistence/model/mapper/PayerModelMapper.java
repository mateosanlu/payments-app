package com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.PayerModel;
import com.sandoval.paymentservice.domain.model.Payer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayerModelMapper {

    PayerModelMapper INSTANCE = Mappers.getMapper(PayerModelMapper.class);

    PayerModel toPayerModel(Payer payer);

    Payer toPayer(PayerModel payerModel);
}
