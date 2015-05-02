package com.vspavlov.demoorm.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Василий on 02.05.2015.
 */

// Security table
@Entity
@Table(name = "USERS")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;

    private String username;
    private String password;


}
