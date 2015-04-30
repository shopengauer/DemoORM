package com.vspavlov.demoorm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Entity
public class Bom implements Serializable {

    @Id
    private Long id;
}
