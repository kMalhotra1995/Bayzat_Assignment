package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.Privileges;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ADMIN")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "BASE_USER")
    public BaseUser baseUser;

    @Column(name = "FIRST_NAME")
    public String firstname;

    @Column(name = "LAST_NAME")
    public String lastname;

    @Column(name = "PRIVILEGES")
    public List<Privileges> privileges;
}
