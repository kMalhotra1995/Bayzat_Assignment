package com.curr.Currencytracker.entity;

import com.curr.Currencytracker.enums.AlertStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "ALERT")
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
