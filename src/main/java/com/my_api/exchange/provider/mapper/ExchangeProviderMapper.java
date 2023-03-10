package com.my_api.exchange.provider.mapper;

import com.my_api.exchange.provider.model.Latest;
import com.my_api.exchange.model.Currency;
import com.my_api.exchange.model.Exchange;
import com.my_api.exchange.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class ExchangeProviderMapper {
    private CurrencyRepository currencyRepository;

    public List<Exchange> toDomain(Latest latest) {
        List<Exchange> exchangeList = new ArrayList<>();
        LocalDate date = LocalDate.parse(latest.getDate());
        for (Map.Entry<String, Float> entry : latest.getRates().entrySet()) {
            Currency currency = currencyRepository.findBySymbol(
                    entry.getKey()
            );
            Exchange exchange = Exchange.builder()
                    .currency(currency)
                    .change(entry.getValue())
                    .date(date)
                    .build();
            exchangeList.add(exchange);
        }
        return exchangeList;
    }
}
