package com.sandoval.tokenizerservice.infrastructure.out.persistence;

import com.sandoval.tokenizerservice.infrastructure.out.persistence.model.TokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenJpaRepository extends JpaRepository<TokenModel, String> {

    TokenModel findByToken(String token);
}