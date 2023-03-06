package com.my_api.exchange.controller.mapper;

import com.my_api.exchange.controller.dto.CurrencyDto;
import com.my_api.exchange.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {
    public CurrencyDto toRest(Currency currency) {
        return CurrencyDto.builder()
                .symbol(currency.getSymbol())
                .value(currency.getValue())
                .build();
    }
}
