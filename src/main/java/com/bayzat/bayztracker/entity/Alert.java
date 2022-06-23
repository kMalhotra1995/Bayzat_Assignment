package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.AlertStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "Alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String currency;

    @Column
    public Double targetPrice;

    @Column
    public Instant createdAt;

    @Column
    public AlertStatus status;
}
