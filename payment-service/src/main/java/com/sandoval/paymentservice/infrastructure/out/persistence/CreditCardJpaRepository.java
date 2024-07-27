package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardJpaRepository extends JpaRepository<CreditCardModel, String> {
}
