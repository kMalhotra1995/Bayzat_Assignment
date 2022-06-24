package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepository  extends JpaRepository<Alert,Long> {
    @Query(value = "SELECT * FROM Alert WHERE status=0", nativeQuery = true)
    List<Alert> getNewAlerts();
}
