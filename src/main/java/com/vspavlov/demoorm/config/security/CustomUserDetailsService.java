package com.vspavlov.demoorm.config.security;

import com.vspavlov.demoorm.domain.User;
import com.vspavlov.demoorm.repository.UserRepository;
import com.vspavlov.demoorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Василий on 02.05.2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {


     @Autowired
     private UserRepository userRepository;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // User user = userRepository.findByUsername(userName);
          User user = userRepository.findAll().get(0);
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());

//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("user");
        if(user == null){
            throw new UsernameNotFoundException("UserName "+ userName+" not found");
        }

        return new SecurityUser(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
