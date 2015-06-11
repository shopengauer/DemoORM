package com.vspavlov.demoorm.registration;

import com.vspavlov.demoorm.domain.users.MdbUser;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by vasiliy on 04.06.15.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent{

    private final String appUrl;
    private final Locale locale;
    private final MdbUser user;


//    public OnRegistrationCompleteEvent(Object source) {
//        super(source);
//    }

    public OnRegistrationCompleteEvent(Object source,MdbUser user, Locale locale, String appUrl) {
        super(source);
        this.appUrl = appUrl;
        this.locale = locale;
        this.user = user;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public MdbUser getUser() {
        return user;
    }
}
