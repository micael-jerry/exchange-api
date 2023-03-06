package com.my_api.exchange.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateBean {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
