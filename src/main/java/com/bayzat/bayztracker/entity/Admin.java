package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.Privileges;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "BASE_USER_ID")
    public BaseUser baseUser;

}
