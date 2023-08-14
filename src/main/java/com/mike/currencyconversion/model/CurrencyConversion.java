package com.mike.currencyconversion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Table(name = "currency_conversion")
public class CurrencyConversion {

    @Id
    private UUID id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    @Column(name = "total_calculated_amount")
    private BigDecimal totalCalculatedAmount;
    private LocalDateTime time;
}
