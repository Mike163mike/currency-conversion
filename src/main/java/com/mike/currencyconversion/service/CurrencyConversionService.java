package com.mike.currencyconversion.service;

import com.mike.currencyconversion.dto.CalculateAmountDTO;
import com.mike.currencyconversion.feign.CurrencyConversionFeignClient;
import com.mike.currencyconversion.model.CurrencyConversion;
import com.mike.currencyconversion.repository.CurrencyConversionQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    public final CurrencyConversionQueryRepository currencyConversionQueryRepository;
    public final CurrencyConversionFeignClient currencyConversionFeignClient;

    public CalculateAmountDTO getCurrencyAmount(Integer amountForCalculate, String from, String to) {
        var exchangeValueDto = currencyConversionFeignClient.getExchangeValue(from, to);
        var totalCalculateAmount = exchangeValueDto.conversionMultiple().multiply(BigDecimal.valueOf(amountForCalculate))
                .setScale(2, RoundingMode.HALF_UP);
        var calculateAmountDTO = new CalculateAmountDTO(from, to, BigDecimal.valueOf(amountForCalculate), totalCalculateAmount);
        saveQuery(calculateAmountDTO);
        return calculateAmountDTO;
    }

    public List<CurrencyConversion> getQueriesByPeriod(LocalDateTime from, LocalDateTime to) {
        return currencyConversionQueryRepository.getCurrencyConversionByTimeAfterAndTimeBefore(from, to);
    }

    public void saveQuery(CalculateAmountDTO calculateAmountDTO) {
        var currencyConversion = new CurrencyConversion();
        currencyConversion.setId(UUID.randomUUID());
        currencyConversion.setFrom(calculateAmountDTO.from());
        currencyConversion.setTo(calculateAmountDTO.to());
        currencyConversion.setConversionMultiple(calculateAmountDTO.totalCalculateAmount()
                .divide(calculateAmountDTO.quantity(), 4, RoundingMode.HALF_UP));
        currencyConversion.setQuantity(calculateAmountDTO.quantity());
        currencyConversion.setTotalCalculatedAmount(calculateAmountDTO.totalCalculateAmount());
        currencyConversion.setTime(LocalDateTime.now());
        currencyConversionQueryRepository.save(currencyConversion);
    }

    public Map<String, String> getAllpassibleCurrencies() {
        return currencyConversionFeignClient.getAllPossibleCurrencies();
    }
}
