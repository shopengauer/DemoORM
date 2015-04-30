package com.vspavlov.demoorm.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Vasiliy on 28.04.2015.
 */
//@Entity
public class Docum extends ResourceSupport {

    private String docum;

    @JsonCreator
    public Docum(@JsonProperty(value = "docum") String docum) {
        this.docum = docum;
    }

    public String getDocum() {
        return docum;
    }
}
