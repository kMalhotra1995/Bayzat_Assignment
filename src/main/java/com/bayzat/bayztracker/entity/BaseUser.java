package com.bayzat.bayztracker.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
@Entity
@Table(name = "BASE_USER")
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 5, message = "username should have atleast 2 characters")
    public String username;

    @Column
    public Boolean isActive;

    @Column(nullable = false)
    @NotEmpty
    public String password;

    @Column(nullable = false)
    @NotEmpty
    @Email
    public String email;
}
