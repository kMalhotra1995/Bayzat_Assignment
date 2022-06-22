package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.Currency;
import com.bayzat.bayztracker.repository.AdminRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import com.bayzat.bayztracker.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements Myservice{
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
    public BaseUser getBaseUser(String username) {
        return this.baseUserRepository.findByUsername(username);
    }

    @Override
    public Admin getAdmin(Long id) {
        if(adminRepository.findById(id).isPresent()){
            return this.adminRepository.findById(id).get();
        }else {
            throw new UsernameNotFoundException("Not and admin user");
        }
    }

    @Override
    public void deleteCurrency(Long id) {
        this.adminRepository.deleteById(id);
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

}
