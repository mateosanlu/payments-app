package com.sandoval.paymentservice.infrastructure.out.persistence;

import com.sandoval.paymentservice.infrastructure.out.persistence.model.BillingAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressJpaRepository extends JpaRepository<BillingAddressModel, String> {
}
