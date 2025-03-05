package com.microservices.currency_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<com.microservices.currency_service.model.entity.Currency, Long> {
    
    Optional<com.microservices.currency_service.model.entity.Currency> findByFromAndTo(String from, String to);
}
