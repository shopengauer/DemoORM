package com.vspavlov.demoorm.config.email;

/**
 * Created by vasiliy on 04.06.15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
//@PropertySource(value = "classpath:email.properties")
@ConfigurationProperties(value = "classpath:email.properties",prefix = "mail",ignoreUnknownFields = false)
public class EmailConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static class Smtp {

        private boolean auth;
        private boolean starttlsEnable;

        // ... getters and setters

        public boolean isAuth() {
            return auth;
        }

        public void setAuth(boolean auth) {
            this.auth = auth;
        }

        public boolean isStarttlsEnable() {
            return starttlsEnable;
        }

        public void setStarttlsEnable(boolean starttlsEnable) {
            this.starttlsEnable = starttlsEnable;
        }
    }

    private String protocol;

    private String host;

    private int port;

    private String from;

    private String username;
    private String password;
    private Smtp smtp = new Smtp();



    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", false);
        mailProperties.put("mail.smtp.starttls.enable",true);
        mailSender.setJavaMailProperties(mailProperties);
        //mailSender.setHost(host);
        mailSender.setHost("smtp.gmail.com");

        //logger.error(host);
       // mailSender.setPort(port);
        mailSender.setPort(587);// 465
        mailSender.setProtocol("smtp");
        mailSender.setUsername("vspavlov79@gmail.com");
        mailSender.setPassword("Asalema1963");
        return mailSender;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Smtp getSmtp() {
        return smtp;
    }

    public void setSmtp(Smtp smtp) {
        this.smtp = smtp;
    }
}
