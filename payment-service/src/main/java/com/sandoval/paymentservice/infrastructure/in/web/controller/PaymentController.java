package com.sandoval.paymentservice.infrastructure.in.web.controller;

import com.sandoval.paymentservice.application.dto.PaymentRequestDto;
import com.sandoval.paymentservice.application.dto.TransactionResponseDto;
import com.sandoval.paymentservice.application.port.in.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<TransactionResponseDto> createPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return new ResponseEntity<>(paymentService.savePayment(paymentRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/payments/{transactionId}")
    public ResponseEntity<TransactionResponseDto> getPayment(@PathVariable String transactionId) {
        return new ResponseEntity<>(paymentService.getPayment(transactionId), HttpStatus.OK);
    }

    @GetMapping("/refunds/{transactionId}")
    public ResponseEntity<TransactionResponseDto> processRefund(@PathVariable String transactionId) {
        return new ResponseEntity<>(paymentService.processRefund(transactionId),HttpStatus.CREATED);
    }
}
