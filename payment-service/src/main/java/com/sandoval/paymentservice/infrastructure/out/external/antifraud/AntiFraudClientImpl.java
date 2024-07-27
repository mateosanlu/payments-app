package com.sandoval.paymentservice.infrastructure.out.external.antifraud;

import com.sandoval.paymentservice.application.port.out.AntiFraudClient;
import com.sandoval.paymentservice.application.dto.AntiFraudRequestDto;
import com.sandoval.paymentservice.application.dto.AntiFraudResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AntiFraudClientImpl implements AntiFraudClient {

    private final AntiFraudFeignClient antiFraudFeignClient;

    @Override
    public AntiFraudResponseDto checkFraud(AntiFraudRequestDto antiFraudRequestDto) {
        return antiFraudFeignClient.checkFraud(antiFraudRequestDto);
    }
}
