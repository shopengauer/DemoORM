package com.vspavlov.demoorm.domain;





import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Entity
@Table(name = "TECHOBJECT_TYPE")
@NamedQueries( {@NamedQuery(name = "TechObjectType.findAll",query = "SELECT t FROM TechObjectType t")})
public class TechObjectType implements Serializable {


       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private int id;


       private String nametype;

       private String desctype;

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getNametype() {
              return nametype;
       }

       public void setNametype(String nametype) {
              this.nametype = nametype;
       }

       public String getDesctype() {
              return desctype;
       }

       public void setDesctype(String desctype) {
              this.desctype = desctype;
       }
}
