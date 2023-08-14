package com.mike.currencyconversion.controller;

import com.mike.currencyconversion.dto.CalculateAmountDTO;
import com.mike.currencyconversion.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculateAmountController {

    public final CurrencyConversionService currencyConversionService;

    @GetMapping("/info")
    public ResponseEntity<?> getAllPossibleCurrencies() {
        return ResponseEntity.ok(currencyConversionService.getAllpassibleCurrencies());
    }

    @GetMapping("/{from}/{to}/{sum}")
    public ResponseEntity<CalculateAmountDTO> calculateSum(@PathVariable("from") String from, @PathVariable("to") String to,
                                                           @PathVariable("sum") String sum) {
        return ResponseEntity.ok(currencyConversionService.getCurrencyAmount(Integer.valueOf(sum), from, to));
    }

}
