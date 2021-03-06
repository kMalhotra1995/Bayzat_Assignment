package com.curr.Currencytracker.jobs;

import com.curr.Currencytracker.common.Constants;
import com.curr.Currencytracker.entity.Alert;
import com.curr.Currencytracker.entity.Currency;
import com.curr.Currencytracker.enums.AlertStatus;
import com.curr.Currencytracker.repository.AlertRepository;
import com.curr.Currencytracker.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class AlertTriggerJob {
    @Autowired
    AlertRepository alertRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    private static final Logger LOG = LoggerFactory.getLogger(AlertTriggerJob.class);

    @Scheduled(fixedDelay = 30000)
    public void checkTargetPrice(){
        List<Alert> newAlerts = alertRepository.getNewAlerts();

        List<Currency> listOfCurrencies = currencyRepository.findAll();

        for(Alert alert : newAlerts){
            for(Currency currency : listOfCurrencies){
                if(currency.getName().toLowerCase(Locale.ROOT).equals(alert.getCurrency().toLowerCase())){
                    if(currency.getCurrentPrice() >= alert.getTargetPrice()){
                        alert.setStatus(AlertStatus.TRIGGERED);
                        alertRepository.saveAndFlush(alert);
                        LOG.info(Constants.ALERT_TRIGGERED);
                    }
                }
            }
        }

    }

}
