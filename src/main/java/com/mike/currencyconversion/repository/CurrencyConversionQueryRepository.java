package com.mike.currencyconversion.repository;

import com.mike.currencyconversion.model.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyConversionQueryRepository extends JpaRepository<CurrencyConversion, UUID> {

String GET_QUERIES_BY_PERIOD = "select cc from currency_conversion cc where  cc.time between ?1 and ?2";

List<CurrencyConversion> getCurrencyConversionByTimeAfterAndTimeBefore(LocalDateTime from, LocalDateTime to);
}
