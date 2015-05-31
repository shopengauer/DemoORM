package com.vspavlov.demoorm.domain.techobjects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vasiliy on 08.05.2015.
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;
    @Column(name="role_name",nullable=false)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @ManyToOne(optional = false,fetch = FetchType.EAGER)
//    @JoinColumn(name = "FK_USER_ID",referencedColumnName = "USER_ID")
//    private User user;

}


