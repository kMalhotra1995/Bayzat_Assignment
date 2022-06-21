package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
