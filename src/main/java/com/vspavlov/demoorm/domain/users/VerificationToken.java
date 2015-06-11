package com.vspavlov.demoorm.domain.users;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vasiliy on 03.06.15.
 */
@Entity
public class VerificationToken {
   private static final int EXPIRATION = 60 * 24;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String token;

   private boolean verified;


   @OneToOne(targetEntity = MdbUser.class,fetch = FetchType.EAGER)
   @JoinColumn(nullable = false,name = "user_id")
   private MdbUser mdbUser;

   private Date expiryDate;

    public VerificationToken(String token, MdbUser mdbUser) {
        this.token = token;
        this.mdbUser = mdbUser;
        this.verified = false;

    }

    private Date calcExpiredDate(int expiryTimeInMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public MdbUser getMdbUser() {
        return mdbUser;
    }

    public void setMdbUser(MdbUser mdbUser) {
        this.mdbUser = mdbUser;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
