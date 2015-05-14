package com.vspavlov.demoorm.config.security;

import com.vspavlov.demoorm.domain.User;
import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.repository.UserRepository;
import com.vspavlov.demoorm.service.MdbUserService;
import com.vspavlov.demoorm.service.MdbUserServiceImpl;
import com.vspavlov.demoorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * Created by Василий on 02.05.2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MdbUserService service;


    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {

        //  User user = userService.findUserByUsername(userName);

        MdbUser mdbUser = service.getMdbUserByUsername(userName).orElseThrow(new Supplier<UsernameNotFoundException>() {
            @Override
            public UsernameNotFoundException get() {
                return new UsernameNotFoundException(String.format("User with userName=%s was not found", userName));
            }});


//        if(user == null){
//            throw new UsernameNotFoundException("UserName "+ userName+" not found");
//        }

        return new SecurityMdbUser(mdbUser);
    }


}
