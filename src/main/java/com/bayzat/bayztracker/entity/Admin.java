package com.bayzat.bayztracker.entity;

import com.bayzat.bayztracker.enums.Privileges;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "base_user_id")
    public BaseUser baseUser;

//    @Column
//    public List<Privileges> privileges;
}
