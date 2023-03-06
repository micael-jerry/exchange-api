package com.my_api.exchange.provider.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Symbols {
    private boolean success;
    private Map<String, String> symbols;
}
