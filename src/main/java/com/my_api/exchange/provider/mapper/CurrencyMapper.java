package com.my_api.exchange.provider.mapper;

import com.my_api.exchange.provider.model.Symbols;
import com.my_api.exchange.model.Currency;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyMapper {
    public List<Currency> toDomain(Symbols symbols) {
        List<Currency> currencyList = new ArrayList<>();
        for (Map.Entry<String, String> entry : symbols.getSymbols().entrySet()) {
            Currency currency = Currency.builder()
                    .symbol(entry.getKey())
                    .value(entry.getValue())
                    .build();
            currencyList.add(currency);
        }
        return currencyList;
    }
}
