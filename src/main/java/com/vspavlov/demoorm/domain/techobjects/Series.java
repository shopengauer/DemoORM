package com.vspavlov.demoorm.domain.techobjects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Entity
@Table(name = "SERIES")
public class Series implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameseries;
    private String descseries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameseries() {
        return nameseries;
    }

    public void setNameseries(String nameseries) {
        this.nameseries = nameseries;
    }

    public String getDescseries() {
        return descseries;
    }

    public void setDescseries(String descseries) {
        this.descseries = descseries;
    }
}
