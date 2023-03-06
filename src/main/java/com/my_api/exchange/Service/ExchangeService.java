package com.my_api.exchange.Service;

import com.my_api.exchange.model.Exchange;
import com.my_api.exchange.repository.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeService {
    private ExchangeRepository exchangeRepository;

    public List<Exchange> findAll() {
        return exchangeRepository.findAll(Sort.by("date").ascending());
    }

    public List<Exchange> findAllByDate(String date, Boolean latest) {
        if (date != null) {
            return exchangeRepository.findAllByDate(LocalDate.parse(date));
        }
        return exchangeRepository.findAllByDate(LocalDate.now());
    }

    @Transactional
    public List<Exchange> saveAll(List<Exchange> exchangeList) {
        return exchangeRepository.saveAll(exchangeList);
    }
}
