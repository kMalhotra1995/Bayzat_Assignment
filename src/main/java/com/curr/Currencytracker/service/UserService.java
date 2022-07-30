package com.curr.Currencytracker.service;

import com.curr.Currencytracker.entity.Admin;
import com.curr.Currencytracker.entity.BaseUser;
import com.curr.Currencytracker.entity.User;

public interface UserService {
    Admin addAdmin(Admin admin);

    User addUser(User user);

    BaseUser getBaseUser(String username);

    Admin getAdmin(BaseUser baseUser) throws Exception;
}
