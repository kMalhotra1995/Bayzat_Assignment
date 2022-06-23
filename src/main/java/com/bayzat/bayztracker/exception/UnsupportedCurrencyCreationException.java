package com.bayzat.bayztracker.exception;

public class UnsupportedCurrencyCreationException extends Exception{
    public UnsupportedCurrencyCreationException(){
        super("Currency Not supported");
    }
}
