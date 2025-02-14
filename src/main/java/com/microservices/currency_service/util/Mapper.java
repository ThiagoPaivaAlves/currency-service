package com.microservices.currency_service.util;

import com.microservices.currency_service.model.CurrencyDto;
import com.microservices.currency_service.model.entity.Currency;

public class Mapper {
    
    public static Currency currencyEntityMapper(CurrencyDto currencyDto) {
        return Currency.builder()
                       .id(currencyDto.getId())
                       .conversionFactor(currencyDto.getConversionFactor())
                       .from(currencyDto.getFrom())
                       .to(currencyDto.getTo())
                       .build();
    }
    
    public static CurrencyDto currencyDtoMapper(Currency currency){
        return CurrencyDto.builder()
                          .id(currency.getId())
                          .conversionFactor(currency.getConversionFactor())
                          .from(currency.getFrom())
                          .to(currency.getTo())
                          .build();
    }
}
