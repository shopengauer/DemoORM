package com.vspavlov.demoorm.dto;

import com.vspavlov.demoorm.domain.hibervalidator.*;
import com.vspavlov.demoorm.domain.users.MdbRole;
//import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Vasiliy on 12.05.2015.
 */
//@FieldMatch.List({@FieldMatch(firstValue = "password",secondValue = "passwordRepeated",
//                  message = "{notmatch.passwords}")})
@PasswordMatches(message = "{notmatch.passwords}")
public class MdbUserCreateForm {


    @PostConstruct
    public void init(){
       this.username = "";
       this.password = "";
       this.passwordRepeated = "";
       this.email = "";
       this.role = MdbRole.VIEWER_USER;
    }

    @UniqueUser
    @NotBlank(message = "{notblank.username}")
    //@NotNull
    @Size(min = 1,max = 45,message = "{size.username}")
    private String username;


    @UniqueEmail
    @Email(message = "{regexp.email}")
    @Size(min = 3,max = 45,message = "{size.email}")
    //@NotNull
    private String email;

    @NotBlank(message = "{notblank.password}")
    //@NotNull
    private String password;


    @NotBlank(message = "{notblank.password}")
    private String passwordRepeated;


//    @NotNull
    private MdbRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public MdbRole getRole() {
        return role;
    }

    public void setRole(MdbRole role) {
        this.role = role;
    }
}
