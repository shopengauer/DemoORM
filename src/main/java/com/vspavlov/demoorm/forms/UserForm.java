package com.vspavlov.demoorm.forms;

/**
 * Created by Vasiliy on 30.04.2015.
 */
public class UserForm {

    private String username;
    private String password;

    public UserForm() {
    }

    public UserForm(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
