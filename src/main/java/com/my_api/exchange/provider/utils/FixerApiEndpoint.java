package com.my_api.exchange.provider.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FixerApiEndpoint {
    private static final String BASE_URL = "https://api.apilayer.com/fixer";

    public static String symbols() {
        return BASE_URL + "/symbols";
    }

    public static String latest(String base) {
        if (base != null) {
            return BASE_URL + "/latest" + "?base=" + base;
        }
        return BASE_URL + "/latest";
    }
}
