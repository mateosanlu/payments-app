package com.sandoval.paymentservice.infrastructure.out.external.bank;

import com.sandoval.paymentservice.application.dto.BankRequestDto;
import com.sandoval.paymentservice.application.dto.BankResponseDto;
import com.sandoval.paymentservice.application.port.out.BankClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankClientImpl implements BankClient {

    private final BankFeignClient bankFeignClient;

    @Override
    public BankResponseDto processPayment(BankRequestDto bankRequestDto) {
        return bankFeignClient.processPayment(bankRequestDto);
    }
}
