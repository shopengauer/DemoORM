package com.vspavlov.demoorm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Василий on 02.05.2015.
 */

// Security table
@Entity
@Table(name = "USERS")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinColumn(name="user_id")
//    private Set<Role> roles = new HashSet<>();

//    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    private Set<Role> roles;

    public User() {
    }

    public User(String name, String email, String password) {
        this.username = name;
        this.email = email;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
