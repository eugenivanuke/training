package com.cooler.service;

import com.cooler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by clr on 08.06.2017.
 */

@Component
public class FormToMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void setMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("gorgeousrichie01@gmail.com");
        message.setSubject("check-check-one-two");
        message.setText(user.getFirstName()+", "
                +user.getLastName()+", "
                +user.getTelNumber());
        javaMailSender.send(message);
    }
}
