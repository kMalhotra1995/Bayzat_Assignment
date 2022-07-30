package com.curr.Currencytracker.repository;

import com.curr.Currencytracker.common.Constants;
import com.curr.Currencytracker.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepository  extends JpaRepository<Alert,Long> {
    @Query(value = Constants.QUERY_ALERT_TRIGGER, nativeQuery = true)
    List<Alert> getNewAlerts();
}
