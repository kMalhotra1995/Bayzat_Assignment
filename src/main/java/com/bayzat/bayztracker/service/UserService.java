package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.User;

public interface UserService {
    Admin addAdmin(Admin admin);

    User addUser(User user);

    BaseUser getBaseUser(String username);

    Admin getAdmin(Long id) throws Exception;
}
