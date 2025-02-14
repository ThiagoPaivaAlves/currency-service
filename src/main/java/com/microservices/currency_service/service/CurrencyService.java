package com.microservices.currency_service.service;

import com.microservices.currency_service.util.Mapper;
import com.microservices.currency_service.model.CurrencyDto;
import com.microservices.currency_service.repository.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyService {
    
    @Autowired
    private Environment environment;
    
    @Autowired
    private Currency repository;
    
    public CurrencyDto getConvertedCurrency(BigDecimal amount, String from, String to){
    
    com.microservices.currency_service.model.entity.Currency currency = repository.findByFromAndTo(from, to)
                  .orElseThrow(RuntimeException::new);
        
        CurrencyDto convertedValue = Mapper.currencyDtoMapper(currency);
        convertedValue.setConvertedValue(
                convertedValue.getConversionFactor().multiply(amount).setScale(2, RoundingMode.CEILING));
        convertedValue.setEnvironment(environment.getProperty("local.server.port"));
        
        return convertedValue;
        
    }
}
