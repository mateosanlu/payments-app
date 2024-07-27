package com.sandoval.paymentservice.infrastructure.out.external.tokenization;

import com.sandoval.paymentservice.application.dto.TokenRequest;
import com.sandoval.paymentservice.application.dto.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tokenization-service", url = "${tokenizer.service.url}")
public interface TokenizationFeignClient {

    @PostMapping("/tokens")
    TokenResponse tokenize(@RequestBody TokenRequest request);
}
