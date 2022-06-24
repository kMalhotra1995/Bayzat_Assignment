package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Alert;
import com.bayzat.bayztracker.enums.AlertStatus;
import com.bayzat.bayztracker.exception.UnsupportedCurrencyCreationException;
import com.bayzat.bayztracker.repository.AlertRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private BaseUserRepository baseUserRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private CurrencyService currencyService;

    @Override
    public Alert save(Alert a) throws UnsupportedCurrencyCreationException {
        if(currencyService.validateCurrency(a.getCurrency()))
            a.setCurrency(a.getCurrency());
        else
            throw new UnsupportedCurrencyCreationException();
        a.setCreatedAt(Instant.now());
        a.setStatus(AlertStatus.NEW);
        return this.alertRepository.saveAndFlush(a);
    }

    @Override
    public Alert update(Alert a) throws Exception {
        Optional<Alert> ua = alertRepository.findById(a.getId());
        if(ua.isPresent() ){
            Alert alert = ua.get();
            alert.setCreatedAt(Instant.now());
            if(currencyService.validateCurrency(a.getCurrency()))
                alert.setCurrency(a.getCurrency());
            else
                throw new UnsupportedCurrencyCreationException();
            alert.setStatus(AlertStatus.NEW);
            alert.setTargetPrice(a.getTargetPrice());
            return alertRepository.saveAndFlush(alert);
        }else{
            throw new Exception("Invalid Alert data");
        }
    }

    @Override
    public Boolean delete(Long alertId) throws Exception {
        Optional<Alert> al = alertRepository.findById(alertId);
        if(al.isPresent()){
            alertRepository.delete(al.get());
            alertRepository.flush();
            return true;
        }else{
            throw new Exception("Alert not found");
        }
    }

    @Override
    public Alert cancel(Long alertId) throws Exception{
        Optional<Alert> al = alertRepository.findById(alertId);
        if(al.isPresent() && al.get().getStatus().equals(AlertStatus.NEW)){
            Alert alert = al.get();
            alert.setStatus(AlertStatus.CANCELLED);
            return alertRepository.saveAndFlush(alert);
        }else{
            throw new Exception("Could not cancel the alert (maybe its already triggered)");
        }
    }



}
