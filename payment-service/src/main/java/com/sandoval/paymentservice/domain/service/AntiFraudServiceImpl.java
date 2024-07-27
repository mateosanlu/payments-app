package com.sandoval.paymentservice.domain.service;

import com.sandoval.paymentservice.application.dto.mapper.AntiFraudMapper;
import com.sandoval.paymentservice.application.port.in.AntiFraudService;
import com.sandoval.paymentservice.application.port.out.AntiFraudClient;
import com.sandoval.paymentservice.domain.model.AntiFraudRequest;
import com.sandoval.paymentservice.domain.model.AntiFraudResponse;
import com.sandoval.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AntiFraudServiceImpl implements AntiFraudService {

    private final AntiFraudClient antiFraudClient;

    @Override
    public boolean isFraudulent(Payment payment) {
        AntiFraudRequest antiFraudRequest = createAntiFraudRequest(payment);
        AntiFraudResponse antiFraudResponse = AntiFraudMapper.INSTANCE.toDomain(
                antiFraudClient.checkFraud(AntiFraudMapper.INSTANCE.toDto(antiFraudRequest))
        );
        return antiFraudResponse.getResponseCode().equals("FRAUD_REJECTED");
    }

    private AntiFraudRequest createAntiFraudRequest(Payment payment) {
        return AntiFraudRequest.builder()
                .cardToken(payment.getCreditCard().getCardNumber())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .firstName(payment.getPayer().getFirstName())
                .lastName(payment.getPayer().getLastName())
                .email(payment.getPayer().getEmail())
                .street(payment.getPayer().getBillingAddress().getStreet())
                .city(payment.getPayer().getBillingAddress().getCity())
                .country(payment.getPayer().getBillingAddress().getCountry())
                .build();
    }
}
