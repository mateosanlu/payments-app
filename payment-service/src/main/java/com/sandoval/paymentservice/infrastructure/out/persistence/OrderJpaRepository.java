package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderModel, String> {
}
