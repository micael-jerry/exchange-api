package com.my_api.exchange.Service;

import com.my_api.exchange.model.Exchange;
import com.my_api.exchange.repository.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ExchangeService {
    private ExchangeRepository exchangeRepository;

    public List<Exchange> findAll() {
        return exchangeRepository.findAll(Sort.by("date").ascending());
    }

    public List<Exchange> findAllByDate(String dateString) {
        if (Objects.equals("latest", dateString)) {
            return exchangeRepository.findAllByDate(LocalDate.now());
        }
        else if (dateString.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return exchangeRepository.findAllByDate(LocalDate.parse(dateString));
        }
        throw new RuntimeException("Invalid date format");
    }

    @Transactional
    public List<Exchange> saveAll(List<Exchange> exchangeList) {
        return exchangeRepository.saveAll(exchangeList);
    }
}
