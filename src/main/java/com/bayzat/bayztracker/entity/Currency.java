package com.bayzat.bayztracker.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String symbol;

    @Column
    public Double currentPrice;

    @Column
    public Instant createdTime;

    @Column
    public Boolean enabled;
}
