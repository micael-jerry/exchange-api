package com.my_api.exchange.Service.DomainClientService;

import com.my_api.exchange.Service.ExchangeService;
import com.my_api.exchange.client.mapper.ExchangeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExchangeLatestService {
    private com.my_api.exchange.client.service.Service clientService;
    private ExchangeService exchangeService;
    private ExchangeMapper exchangeMapper;
}
