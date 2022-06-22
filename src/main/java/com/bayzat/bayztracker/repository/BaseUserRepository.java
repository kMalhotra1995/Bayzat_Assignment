package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByUsername(String username);
}
