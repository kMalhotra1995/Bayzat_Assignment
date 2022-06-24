package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.common.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "BASE_USER")
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 5, message = Constants.DB_BASE_USER_USERNAME_MSG)
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
