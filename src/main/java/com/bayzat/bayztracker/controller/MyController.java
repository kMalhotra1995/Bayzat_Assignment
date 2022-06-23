package com.bayzat.bayztracker.controller;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.Currency;
import com.bayzat.bayztracker.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bayztracker")
public class MyController {
    @Autowired
    Myservice myservice;

    @PostMapping("/addCurrency")
    public ResponseEntity<?> addCurrency(@RequestBody Currency currency, @RequestHeader(value = "username") String username) throws Exception {
        BaseUser baseUser = this.myservice.getBaseUser(username);
        Admin admin = this.myservice.getAdmin(baseUser);
        if(admin != null){
            Currency newCurrency = this.myservice.saveCurrency(currency) ;
            return ResponseEntity.ok(newCurrency);
        }
        else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/deleteCurrency/{currencyId}")
    public ResponseEntity<HttpStatus> deleteCurrency(@RequestBody Currency currency, @RequestHeader(value = "username") String username , @RequestParam("currencyId") Long id) throws Exception {
        BaseUser baseUser = this.myservice.getBaseUser(username);
        Admin admin = this.myservice.getAdmin(baseUser);
        if(admin != null){
            if(this.myservice.getCurrency(id) == true) {
                this.myservice.deleteCurrency(id);
                return ResponseEntity.ok(HttpStatus.OK);
            }
            else {
                //return ResponseEntity.status(HttpStatus.UNAUTHORIZED);
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
