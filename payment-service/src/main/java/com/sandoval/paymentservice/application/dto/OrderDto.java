package com.sandoval.paymentservice.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private String orderId;
    private String description;
}
