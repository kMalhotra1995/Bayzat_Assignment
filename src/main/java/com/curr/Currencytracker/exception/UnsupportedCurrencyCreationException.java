package com.curr.Currencytracker.exception;

import com.curr.Currencytracker.common.Constants;

public class UnsupportedCurrencyCreationException extends Exception{
    public UnsupportedCurrencyCreationException(){
        super(Constants.CURRENCY_UNSUPPORTED_EXCEPTION);
    }
}
