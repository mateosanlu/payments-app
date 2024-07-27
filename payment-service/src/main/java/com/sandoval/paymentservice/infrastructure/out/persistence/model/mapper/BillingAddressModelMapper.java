package com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.BillingAddressModel;
import com.sandoval.paymentservice.domain.model.BillingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillingAddressModelMapper {

    BillingAddressModelMapper INSTANCE = Mappers.getMapper(BillingAddressModelMapper.class);

    BillingAddressModel toBillingAddressModel(BillingAddress billingAddress);

    BillingAddress toBillingAddress(BillingAddressModel billingAddressModel);
}
