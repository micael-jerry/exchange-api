package com.my_api.exchange.provider.service;

import com.my_api.exchange.Service.ExchangeService;
import com.my_api.exchange.model.Exchange;
import com.my_api.exchange.provider.mapper.ExchangeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LatestToExchangeService {
    private ProviderService providerService;
    private ExchangeService exchangeService;
    private ExchangeMapper exchangeMapper;

    public List<Exchange> saveExchangeFromProvider() {
        String base = "USD";
        List<Exchange> exchangeList = exchangeMapper
                .toDomain(
                        providerService.getLatest(base)
                );
        return exchangeService.saveAll(exchangeList);
    }
}
