package com.mike.currencyconversion.feign;

import com.mike.currencyconversion.dto.ExchangeValueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CurrencyConversionFeignClient {

    @GetMapping("/from/{from}/to/{to}")
    ExchangeValueDto getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

    @GetMapping("/info")
    Map<String, String> getAllPossibleCurrencies();
}
