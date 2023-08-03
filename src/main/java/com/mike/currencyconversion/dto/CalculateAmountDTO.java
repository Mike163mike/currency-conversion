package com.mike.currencyconversion.dto;

import java.math.BigDecimal;

public record CalculateAmountDTO(String from, String to, BigDecimal quantity, BigDecimal totalCalculateAmount) {
}
