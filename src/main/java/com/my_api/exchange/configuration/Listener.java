package com.my_api.exchange.configuration;

import com.my_api.exchange.provider.service.LatestToExchangeService;
import com.my_api.exchange.provider.service.SymbolToCurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@AllArgsConstructor
public class Listener {
    private final SymbolToCurrencyService symbolToCurrencyService;
    private final LatestToExchangeService latestToExchangeService;

    @EventListener(ApplicationReadyEvent.class)
    public void saveCurrentChange() {
        try {
            symbolToCurrencyService.saveCurrencyFromProvider();
            latestToExchangeService.saveExchangeFromProvider();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
