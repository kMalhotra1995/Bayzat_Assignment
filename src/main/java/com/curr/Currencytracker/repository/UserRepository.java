package com.curr.Currencytracker.repository;

import com.curr.Currencytracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
