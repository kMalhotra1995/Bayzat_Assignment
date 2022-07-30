package com.curr.Currencytracker.service;

import com.curr.Currencytracker.entity.Alert;
import com.curr.Currencytracker.exception.UnsupportedCurrencyCreationException;

public interface AlertService {
    Alert save(Alert a) throws UnsupportedCurrencyCreationException;

    Alert update(Alert a) throws Exception;

    Boolean delete(Long alertId) throws Exception;

    Alert cancel(Long alertId) throws Exception;
}
