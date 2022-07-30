package com.curr.Currencytracker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @OneToOne
    @JoinColumn(name = "BASE_USER_ID")
    public BaseUser baseUser;

    @Column(name = "FIRST_NAME", nullable = false)
    @NotEmpty
    public String firstname;

    @Column(name = "LAST_NAME", nullable = false)
    @NotEmpty
    public String lastname;

}
