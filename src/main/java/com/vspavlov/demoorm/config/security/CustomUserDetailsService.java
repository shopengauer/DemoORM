package com.vspavlov.demoorm.config.security;

import com.vspavlov.demoorm.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Василий on 02.05.2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = new User();

        return new SecurityUser(user);
    }
}
