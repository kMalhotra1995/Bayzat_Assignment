package com.curr.Currencytracker.repository;

import com.curr.Currencytracker.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByUsername(String username) ;
}
