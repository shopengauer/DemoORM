package com.vspavlov.demoorm.config.security;

import com.vspavlov.demoorm.domain.users.MdbUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vasiliy on 12.05.2015.
 */
public class SecurityMdbUser extends MdbUser implements UserDetails {

    public SecurityMdbUser(MdbUser mdbUser) {

        if(mdbUser != null){
            this.setId(mdbUser.getId());
            this.setUsername(mdbUser.getUsername());
            this.setPasswordHash(mdbUser.getPasswordHash());
            this.setMdbRole(mdbUser.getMdbRole());
            this.setEmail(mdbUser.getEmail());
            this.setEnabled(mdbUser.isEnabled());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.getMdbRole().toString());
        grantedAuthorityList.add(grantedAuthority);


        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return super.getPasswordHash();
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
