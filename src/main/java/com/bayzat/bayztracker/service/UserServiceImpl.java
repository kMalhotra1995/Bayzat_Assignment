package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.common.Constants;
import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.User;
import com.bayzat.bayztracker.repository.AdminRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import com.bayzat.bayztracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BaseUserRepository baseUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin addAdmin(Admin admin){
        admin.setBaseUser(baseUserRepository.save(admin.getBaseUser()));
        return adminRepository.save(admin);
    }

    @Override
    public User addUser(User user){
        user.setBaseUser(baseUserRepository.save(user.getBaseUser()));
        return userRepository.save(user);
    }

    @Override
    public BaseUser getBaseUser(String username) {
        return this.baseUserRepository.findByUsername(username);
    }

    @Override
    public Admin getAdmin(BaseUser baseUser) throws Exception {
        if(adminRepository.findByBaseUser(baseUser).isPresent()){
            return this.adminRepository.findByBaseUser(baseUser).get();
        }else {
            throw new Exception(Constants.NOT_AN_ADMIN_USER);
        }
    }
}
