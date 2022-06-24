package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Admin;
import com.bayzat.bayztracker.entity.BaseUser;
import com.bayzat.bayztracker.entity.User;
import com.bayzat.bayztracker.repository.AdminRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import com.bayzat.bayztracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private AdminRepository adminRepository;

    @Mock
    private BaseUserRepository baseUserRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser(){
        User u1 = new User();
        BaseUser b1 = new BaseUser();

        b1.setUsername("harry.potter");
        b1.setEmail("harry.potter@hogwarts.com");
        b1.setId(1L);
        b1.setIsActive(true);
        b1.setPassword("theChosenOne");

        u1.setBaseUser(b1);
        u1.setId(1L);
        u1.setFirstname("Harry");
        u1.setLastname("Potter");

        //when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
        when(userRepository.save(u1)).thenReturn(u1);
        when(baseUserRepository.save(b1)).thenReturn(b1);

        User u2 = userService.addUser(u1);
        assertThat(u2.getBaseUser().getUsername()).isEqualToIgnoringCase("harry.potter");
    }

    @Test
    public void testAddAdmin(){
        Admin a1 = new Admin();
        BaseUser b1 = new BaseUser();

        b1.setUsername("harry.potter");
        b1.setEmail("harry.potter@hogwarts.com");
        b1.setId(1L);
        b1.setIsActive(true);
        b1.setPassword("theChosenOne");

        a1.setBaseUser(b1);
        a1.setId(1L);

        when(adminRepository.save(a1)).thenReturn(a1);
        when(baseUserRepository.save(b1)).thenReturn(b1);

        Admin a2 = userService.addAdmin(a1);
        assertThat(a2.getBaseUser().getUsername()).isEqualToIgnoringCase("harry.potter");
    }

    @Test
    public void testGetAdmin() throws Exception {
        Admin a1 = new Admin();
        BaseUser b1 = new BaseUser();

        b1.setUsername("harry.potter");
        b1.setEmail("harry.potter@hogwarts.com");
        b1.setId(1L);
        b1.setIsActive(true);
        b1.setPassword("theChosenOne");

        a1.setBaseUser(b1);
        a1.setId(1L);

        when(adminRepository.findByBaseUser(b1)).thenReturn(Optional.of(a1));

        Admin a2 = userService.getAdmin(b1);
        assertThat(a2.getBaseUser().getUsername()).isEqualToIgnoringCase("harry.potter");
    }

}
