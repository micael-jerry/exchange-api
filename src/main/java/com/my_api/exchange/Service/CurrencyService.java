package com.my_api.exchange.Service;

import com.my_api.exchange.model.Currency;
import com.my_api.exchange.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency findById(Integer id) {
        return currencyRepository.getReferenceById(id);
    }

    public List<Currency> findAllBySymbolList(List<String> symbols) {
        List<Currency> currencyList = new ArrayList<>();
        for (Currency currency : this.findAll()) {
            if (symbols.contains(currency.getSymbol())) {
                currencyList.add(currency);
            }
        }
        return currencyList;
    }

    @Transactional
    public List<Currency> saveAll(List<Currency> currencyList) {
        return currencyRepository.saveAll(currencyList);
    }
}
