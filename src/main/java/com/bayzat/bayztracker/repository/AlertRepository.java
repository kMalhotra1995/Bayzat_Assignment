package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository  extends JpaRepository<Alert,Long> {
}
