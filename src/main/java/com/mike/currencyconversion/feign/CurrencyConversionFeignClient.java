package com.mike.currencyconversion.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CurrencyConversionFeignClient {

//    @GetMapping("/from/{from}/to/{to}")
//    public ResponseEntity<?>
}
