package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.AlertStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@Entity
@Table(name = "Alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    @NotEmpty
    public String currency;

    @Column(nullable = false)
    @NotEmpty
    public Double targetPrice;

    @Column
    public Instant createdAt;

    @Column(nullable = false)
    @NotEmpty
    public AlertStatus status;
}
