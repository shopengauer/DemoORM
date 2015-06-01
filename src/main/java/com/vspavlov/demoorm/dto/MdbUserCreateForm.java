package com.vspavlov.demoorm.dto;

import com.vspavlov.demoorm.domain.users.MdbRole;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

/**
 * Created by Vasiliy on 12.05.2015.
 */
public class MdbUserCreateForm {

    @PostConstruct
    public void init(){
       this.username = "";
       this.password = "";
       this.passwordRepeated = "";
       this.email = "";
       this.role = MdbRole.VIEWER_USER;
    }

    @NotBlank(message = "{notblank.username}")
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
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
