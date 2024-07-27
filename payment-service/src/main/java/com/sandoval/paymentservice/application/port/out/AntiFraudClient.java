package com.sandoval.paymentservice.application.port.out;

import com.sandoval.paymentservice.application.dto.AntiFraudRequestDto;
import com.sandoval.paymentservice.application.dto.AntiFraudResponseDto;

public interface AntiFraudClient {

    AntiFraudResponseDto checkFraud (AntiFraudRequestDto antiFraudRequestDto);

}
