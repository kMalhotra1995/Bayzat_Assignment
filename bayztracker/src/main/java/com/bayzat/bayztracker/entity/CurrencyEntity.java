package com.bayzat.bayztracker.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "CurrencyEntity")
public class CurrencyEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String name;
    @Column
    String symbol;
    @Column
    Double currentPrice;
    @Column
    Instant createdTime;
    @Column
    Boolean enabled;
}
