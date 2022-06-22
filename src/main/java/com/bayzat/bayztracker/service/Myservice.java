package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.Currency;

public interface Myservice {
    Currency saveCurrency(Currency currency);

    BaseUser getBaseUser(String username);

    Admin getAdmin(Long id);

    void deleteCurrency(Long id);

    boolean getCurrency(Long id);
}
