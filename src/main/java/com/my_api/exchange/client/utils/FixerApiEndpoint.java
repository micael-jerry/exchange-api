package com.my_api.exchange.client.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FixerApiEndpoint {
    private static String baseUrl = "https://api.apilayer.com/fixer";

    public static String symbols() {
        return baseUrl + "/symbols";
    }

    public static String latest(String base) {
        if (base != null) {
            return baseUrl + "/latest" + "?base=" + base;
        }
        return baseUrl + "/latest";
    }
}
