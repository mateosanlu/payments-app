package com.sandoval.paymentservice.infrastructure.out.external.bank;

import com.sandoval.paymentservice.application.dto.BankRequestDto;
import com.sandoval.paymentservice.application.dto.BankResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bankClient", url = "${bank.service.url}")
public interface BankFeignClient {

    @PostMapping("/process")
    BankResponseDto processPayment(@RequestBody BankRequestDto request);
}
