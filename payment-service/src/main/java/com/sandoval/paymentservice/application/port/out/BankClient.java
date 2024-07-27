package com.sandoval.paymentservice.application.port.out;

import com.sandoval.paymentservice.application.dto.BankRequestDto;
import com.sandoval.paymentservice.application.dto.BankResponseDto;

public interface BankClient {

    BankResponseDto processPayment(BankRequestDto bankRequestDto);
}
