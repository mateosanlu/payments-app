package com.sandoval.paymentservice.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AntiFraudResponse {

    private String responseCode;

}
