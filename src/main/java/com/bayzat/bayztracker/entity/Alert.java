package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.AlertStatus;
import lombok.Data;

import javax.persistence.*;

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
    public String createdAt;
    @Column
    public AlertStatus status;
}
