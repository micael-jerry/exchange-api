package com.my_api.exchange.client.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Getter
@NoArgsConstructor
public class FixerApiEndpoint {
    @Value("${base.url}")
    private static String baseUrl;

    public static String symbols() {
        return baseUrl + "/symbols";
    }

    public static String latest() {
        return baseUrl + "/latest";
    }
}
