package com.my_api.exchange.provider.service;

import com.my_api.exchange.Service.CurrencyService;
import com.my_api.exchange.model.Currency;
import com.my_api.exchange.provider.mapper.CurrencyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SymbolToCurrencyService {
    private ProviderService clientService;
    private CurrencyService currencyService;
    private CurrencyMapper currencyMapper;

    public List<Currency> saveCurrencyFromProvider() {
        List<Currency> currencyList = currencyMapper
                .toDomain(clientService.getSymbols());
        return currencyService.saveAll(currencyList);
    }
}
