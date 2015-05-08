package com.vspavlov.demoorm.config.security;

import com.vspavlov.demoorm.domain.Role;
import com.vspavlov.demoorm.domain.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Василий on 02.05.2015.
 */
//@Component
public class SecurityUser extends User implements UserDetails
{


    public SecurityUser(User user) {
        if(user!=null){
            this.setId(user.getId());
            this.setUsername(user.getUsername());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());

        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        Set<Role> userRoles = this.getRoles();

//        for (Role userRole : userRoles) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRoleName());
//            authorities.add(authority);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            authorities.add(authority);
//        }


        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
      return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
