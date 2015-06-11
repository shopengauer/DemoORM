package com.vspavlov.demoorm.registration.listener;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.registration.OnRegistrationCompleteEvent;
import com.vspavlov.demoorm.service.MdbUserService;
import com.vspavlov.demoorm.service.MdbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

/**
 * Created by vasiliy on 04.06.15.
 */
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {


    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MdbUserService service;

    @Autowired
    private MessageSource messages;



    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {
         this.confirmRegistration(onRegistrationCompleteEvent);
    }


    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        MdbUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
        String message = messages.getMessage("message.succes.registration", null, event.getLocale());
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
        javaMailSender.send(email);
    }

}
