package com.vspavlov.demoorm.registration.listener;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.registration.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

/**
 * Created by vasiliy on 04.06.15.
 */
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent) {

    }


    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        MdbUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }

}
