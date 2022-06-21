package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
