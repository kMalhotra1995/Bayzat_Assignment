package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Alert;
import com.bayzat.bayztracker.exception.UnsupportedCurrencyCreationException;

public interface AlertService {
    Alert save(Alert a) throws UnsupportedCurrencyCreationException;

    Alert update(Alert a) throws Exception;

    Boolean delete(Long alertId) throws Exception;

    Alert cancel(Long alertId) throws Exception;
}
