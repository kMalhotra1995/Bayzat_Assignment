package com.bayzat.bayztracker.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BASE_USER")
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String username;

    @Column
    public Boolean isActive;

    @Column
    public String password;

    @Column
    public String email;
}
