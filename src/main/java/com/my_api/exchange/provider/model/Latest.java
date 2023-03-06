package com.my_api.exchange.provider.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Latest {
    private String base;
    private String date;
    private Map<String, Float> rates;
}
