package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.common.Constants;
import com.bayzat.bayztracker.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepository  extends JpaRepository<Alert,Long> {
    @Query(value = Constants.QUERY_ALERT_TRIGGER, nativeQuery = true)
    List<Alert> getNewAlerts();
}
