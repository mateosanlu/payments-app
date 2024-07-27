package com.sandoval.paymentservice.application.dto.mapper;

import com.sandoval.paymentservice.application.dto.OrderDto;
import com.sandoval.paymentservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDtoMapper {

    OrderDtoMapper INSTANCE = Mappers.getMapper(OrderDtoMapper.class);

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto orderDto);
}
