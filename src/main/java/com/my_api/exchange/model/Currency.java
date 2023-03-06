package com.my_api.exchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "symbol", nullable = false, length = 3, unique = true)
    private String symbol;
    @Column(name = "value", nullable = false, unique = true)
    private String value;
    @OneToMany(mappedBy = "currency")
    private List<Exchange> exchanges;
}
