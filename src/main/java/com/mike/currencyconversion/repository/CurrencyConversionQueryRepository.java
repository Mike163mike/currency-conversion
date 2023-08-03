package com.mike.currencyconversion.repository;

import com.mike.currencyconversion.model.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyConversionQueryRepository extends JpaRepository<CurrencyConversion, UUID> {
}
