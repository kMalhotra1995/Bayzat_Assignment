package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.Privileges;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
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
