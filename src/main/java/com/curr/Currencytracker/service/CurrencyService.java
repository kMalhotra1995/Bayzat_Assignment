package com.curr.Currencytracker.service;

import com.curr.Currencytracker.entity.Admin;
import com.curr.Currencytracker.entity.BaseUser;
import com.curr.Currencytracker.entity.Currency;

public interface CurrencyService {
    Currency saveCurrency(Currency currency);

    BaseUser getBaseUser(String username);


    void deleteCurrency(Long id);

    Admin getAdmin(BaseUser baseUser) throws Exception;

    boolean getCurrency(Long id);

    Boolean validateCurrency(String currency);
}
