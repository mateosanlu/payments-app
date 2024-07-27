package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.PayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayerJpaRepository extends JpaRepository<PayerModel, String> {
}
