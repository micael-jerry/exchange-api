package com.my_api.exchange.configuration;

import com.my_api.exchange.provider.service.LatestToExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class Scheduler {
    private LatestToExchangeService latestToExchangeService;

    @Scheduled(cron = "0 00 03 ? * *")
    public void saveLatest() {
        latestToExchangeService.saveExchangeFromProvider();
    }
}
