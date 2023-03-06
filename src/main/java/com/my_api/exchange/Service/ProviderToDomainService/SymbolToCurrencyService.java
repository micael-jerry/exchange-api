package com.my_api.exchange.Service.DomainClientService;

import com.my_api.exchange.Service.CurrencyService;
import com.my_api.exchange.client.mapper.CurrencyMapper;
import com.my_api.exchange.model.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencySymbolService {
    private com.my_api.exchange.client.service.Service clientService;
    private CurrencyService currencyService;
    private CurrencyMapper currencyMapper;

    public List<Currency> saveCurrencyFromClient() {
        List<Currency> currencyList = currencyMapper
                .toDomain(clientService.getSymbols());
        return currencyService.saveAll(currencyList);
    }
}
