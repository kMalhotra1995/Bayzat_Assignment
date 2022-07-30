package com.curr.Currencytracker.service;

import com.curr.Currencytracker.common.Constants;
import com.curr.Currencytracker.entity.Admin;
import com.curr.Currencytracker.entity.BaseUser;
import com.curr.Currencytracker.entity.Currency;
import com.curr.Currencytracker.enums.UnsupportedCurrency;
import com.curr.Currencytracker.repository.AdminRepository;
import com.curr.Currencytracker.repository.BaseUserRepository;
import com.curr.Currencytracker.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    BaseUserRepository baseUserRepository;
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Currency saveCurrency(Currency currency) {
        return this.currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(Long id) { this.adminRepository.deleteById(id); }

    @Override
    public BaseUser getBaseUser(String username) {
        return this.baseUserRepository.findByUsername(username);
    }

    @Override
    public Admin getAdmin(BaseUser baseUser) throws Exception {

        if(adminRepository.findByBaseUser(baseUser).isPresent()){
            Admin admin = (Admin) this.adminRepository.findByBaseUser(baseUser).get();
            return admin;
        }else {
            throw new Exception(Constants.NOT_AN_ADMIN_USER);
        }
    }

    @Override
    public boolean getCurrency(Long id) {
        if (this.currencyRepository.findById(id).isPresent()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean validateCurrency(String currency) {
        UnsupportedCurrency unsupportedCurrency =  UnsupportedCurrency.findByName(currency);
        if (unsupportedCurrency == null){
            return true;
        }else
        {
            return false;
        }
    }

}
