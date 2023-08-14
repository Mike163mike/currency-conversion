package com.mike.currencyconversion.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ExchangeValueDto(UUID id, String from, String to, BigDecimal conversionMultiple, LocalDateTime time) {
}
