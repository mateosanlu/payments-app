package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.BillingAddressDto;
import com.sandoval.paymentservice.domain.model.BillingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillingAddressDtoMapper {

    BillingAddressDtoMapper INSTANCE = Mappers.getMapper(BillingAddressDtoMapper.class);

    BillingAddressDto toBillingAddressDto(BillingAddress billingAddress);

    BillingAddress toBillingAddress(BillingAddressDto billingAddressDto);
}
