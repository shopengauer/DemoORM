package com.vspavlov.demoorm.domain.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Vasiliy on 12.05.2015.
 */
@Entity
@Table(name = "mdbuser")
public class MdbUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mdbuser_id",unique = true)
    private Long id;

    @Basic(optional = false)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Basic(optional = false)
    @Column(name = "passwordhash")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "mdbrole")
    private MdbRole mdbRole;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public MdbRole getMdbRole() {
        return mdbRole;
    }

    public void setMdbRole(MdbRole mdbRole) {
        this.mdbRole = mdbRole;
    }
}
