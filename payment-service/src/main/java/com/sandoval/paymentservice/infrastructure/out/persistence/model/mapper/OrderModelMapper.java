package com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.OrderModel;
import com.sandoval.paymentservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderModelMapper {

    OrderModelMapper INSTANCE = Mappers.getMapper(OrderModelMapper.class);

    OrderModel toOrderModel(Order order);

    Order toOrder(OrderModel orderModel);
}
