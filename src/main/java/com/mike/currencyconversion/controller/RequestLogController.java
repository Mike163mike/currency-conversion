package com.mike.currencyconversion.controller;

import com.mike.currencyconversion.model.CurrencyConversion;
import com.mike.currencyconversion.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestLogController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/log/{from}/{to}")
    public List<CurrencyConversion> getQueriesByPeriod(@PathVariable("from") String from,
                                                       @PathVariable("to") String to) {
        var formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var localDateTimeFrom = LocalDateTime.parse(from, formatter);
        var localDateTimeTo = LocalDateTime.parse(to, formatter);
        return currencyConversionService.getQueriesByPeriod(localDateTimeFrom, localDateTimeTo);
    }
}
