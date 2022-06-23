package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
//    Boolean findByBaseuser(Long id);
    Optional<Admin> findByBaseUser(BaseUser baseUser);
}
