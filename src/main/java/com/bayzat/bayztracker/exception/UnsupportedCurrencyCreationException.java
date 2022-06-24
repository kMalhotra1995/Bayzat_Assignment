package com.bayzat.bayztracker.exception;

import com.bayzat.bayztracker.common.Constants;

public class UnsupportedCurrencyCreationException extends Exception{
    public UnsupportedCurrencyCreationException(){
        super(Constants.CURRENCY_UNSUPPORTED_EXCEPTION);
    }
}
