package com.my_api.exchange.controller.mapper;

import com.my_api.exchange.controller.dto.ExchangeDto;
import com.my_api.exchange.model.Exchange;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExchangeMapper {
    private CurrencyMapper currencyMapper;

    public ExchangeDto toRest(Exchange exchange) {
        return ExchangeDto.builder()
                .currency(currencyMapper.toRest(exchange.getCurrency()))
                .change(exchange.getChange())
                .build();
    }
}
