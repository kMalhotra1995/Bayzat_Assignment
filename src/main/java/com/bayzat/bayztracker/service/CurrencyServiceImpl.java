package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.Currency;
import com.bayzat.bayztracker.enums.UnsupportedCurrency;
import com.bayzat.bayztracker.repository.AdminRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import com.bayzat.bayztracker.repository.CurrencyRepository;
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

//        if(adminRepository.findById(id).isPresent()){
//            return this.adminRepository.findById(id).get();

        // find by baseuser(base_user_id)
        if(adminRepository.findByBaseUser(baseUser).isPresent()){
            Admin admin = (Admin) this.adminRepository.findByBaseUser(baseUser).get();
            return admin;
        }else {
            throw new Exception("Not and admin user");
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
