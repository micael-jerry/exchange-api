package com.my_api.exchange.controller;

import com.my_api.exchange.Service.CurrencyService;
import com.my_api.exchange.controller.dto.CurrencyDto;
import com.my_api.exchange.controller.mapper.CurrencyMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {
    private CurrencyService currencyService;
    private CurrencyMapper currencyMapper;

    @GetMapping(value = "/symbols")
    public List<CurrencyDto> getAllSymbols() {
        return currencyService.findAll()
                .stream()
                .map(currencyMapper::toRest)
                .toList();
    }

    @GetMapping(value = "/symbols/{id}")
    public CurrencyDto getSymbolById(
            @RequestParam(name = "id") Integer id
    ) {
        return currencyMapper
                .toRest(currencyService.findById(id));
    }

}
