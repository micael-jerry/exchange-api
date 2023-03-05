package com.my_api.exchange.client.service;

import com.my_api.exchange.client.model.Latest;
import com.my_api.exchange.client.model.Symbols;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.my_api.exchange.client.utils.FixerApiEndpoint.latest;
import static com.my_api.exchange.client.utils.FixerApiEndpoint.symbols;

@org.springframework.stereotype.Service
@NoArgsConstructor
public class Service {
    @Value("${api.key}")
    private String apiKey;

    public Symbols getSymbols() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(this.headers());

        ResponseEntity<Symbols> response = restTemplate.exchange(
                symbols(),
                HttpMethod.GET,
                entity,
                Symbols.class
        );

        return response.getBody();
    }

    public Latest getLatest(String base) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>(this.headers());

        ResponseEntity<Latest> response = restTemplate.exchange(
                latest(base),
                HttpMethod.GET,
                httpEntity,
                Latest.class
        );

        return response.getBody();
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        return headers;
    }
}