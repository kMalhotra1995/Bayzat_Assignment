package com.curr.Currencytracker.controller;

import com.curr.Currencytracker.common.ApiConstants;
import com.curr.Currencytracker.entity.Admin;
import com.curr.Currencytracker.entity.BaseUser;
import com.curr.Currencytracker.entity.User;
import com.curr.Currencytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.BASE_USER_URL)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(ApiConstants.ADD_ADMIN)
    public ResponseEntity addAdmin(@RequestBody Admin admin, @RequestHeader(value = "username") String username){
        try{
            BaseUser baseUser = this.userService.getBaseUser(username);
            Admin loggedInAdmin = this.userService.getAdmin(baseUser);
            if(loggedInAdmin != null){
                return new ResponseEntity(userService.addAdmin(admin), HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(ApiConstants.ADD_USER)
    public ResponseEntity addUser(@RequestBody User user){
        try{
            return new ResponseEntity(userService.addUser(user), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
