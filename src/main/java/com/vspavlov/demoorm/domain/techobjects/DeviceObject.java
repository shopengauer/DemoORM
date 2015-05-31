package com.vspavlov.demoorm.domain.techobjects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Entity
@Table(name = "DEVICE_OBJECTS")
public class DeviceObject implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String devicename;
    private String devicecod;

    private String devicetype;

    private String devicedesc;
    private String devicelevel;

   // @ManyToOne(optional = true)
   // @JoinColumn(name = "techObject")
    ///private TechObject techObject;



}
