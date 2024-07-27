package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.application.port.out.PaymentRepository;
import com.sandoval.paymentservice.domain.model.Payment;
import com.sandoval.paymentservice.infrastructure.out.persistence.model.PaymentModel;
import com.sandoval.paymentservice.infrastructure.out.persistence.model.mapper.PaymentModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment save(Payment payment) {
        PaymentModel paymentModel = PaymentModelMapper.INSTANCE.toPaymentModel(payment);
        return PaymentModelMapper.INSTANCE.toPayment(paymentJpaRepository.save(paymentModel));
    }

    @Override
    public Payment findByTransactionId(String transactionId) {
        PaymentModel paymentModel = paymentJpaRepository.findByTransactionId(transactionId);
        return PaymentModelMapper.INSTANCE.toPayment(paymentModel);
    }
}
