package com.sandoval.paymentservice.infrastructure.out.external.antifraud;

import com.sandoval.paymentservice.application.dto.AntiFraudRequestDto;
import com.sandoval.paymentservice.application.dto.AntiFraudResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "antiFraudClient", url = "${anti-fraud.service.url}")
public interface AntiFraudFeignClient {

    @PostMapping("/check")
    AntiFraudResponseDto checkFraud(@RequestBody AntiFraudRequestDto request);
}
