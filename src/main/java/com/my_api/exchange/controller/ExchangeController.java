package com.my_api.exchange.controller;

import com.my_api.exchange.Service.ExchangeService;
import com.my_api.exchange.controller.dto.ExchangeDto;
import com.my_api.exchange.controller.mapper.ExchangeMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExchangeController {
    private ExchangeService exchangeService;
    private ExchangeMapper exchangeMapper;

    @GetMapping(value = "/exchanges")
    public List<ExchangeDto> getAllExchange() {
        return exchangeService.findAll()
                .stream()
                .map(exchangeMapper::toRest)
                .toList();
    }

    @GetMapping(value = "/exchanges/{date}")
    public List<ExchangeDto> getLatest(@PathVariable(name = "date", required = true) String date) {
        return exchangeService.findAllByDate(date)
                .stream()
                .map(exchangeMapper::toRest)
                .toList();
    }
}
