package com.cooler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class Application {

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        mailSender.setJavaMailProperties(properties);

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setProtocol("smtp");
        mailSender.setUsername("gorgeousrichie@gmail.com");
        mailSender.setPassword("");

        return mailSender;
    }

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
