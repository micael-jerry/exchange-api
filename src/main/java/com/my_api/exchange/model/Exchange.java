package com.my_api.exchange.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class Exchange {
    @Id
    private String id;
    @ManyToOne
    @Column(nullable = false)
    private Currency currency;
    @CreatedDate
    private LocalDate date;
}
