package com.curr.Currencytracker.exception;

import com.curr.Currencytracker.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.AbstractMap;

@ControllerAdvice
@Component
public class ExceptionHandler {

    private static final Logger LOG= LoggerFactory.getLogger(ExceptionHandler.class);

    public ResponseEntity<AbstractMap.SimpleEntry<String,String>> handle(Exception exception){
        LOG.error(Constants.CURRENCY_UNSUPPORTED_EXCEPTION,exception);

        AbstractMap.SimpleEntry<String,String> response=new AbstractMap.SimpleEntry<>("message", Constants.CURRENCY_UNSUPPORTED_EXCEPTION);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
