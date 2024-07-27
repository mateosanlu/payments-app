package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentModel, String> {

    PaymentModel findByTransactionId(String transactionId);
}
