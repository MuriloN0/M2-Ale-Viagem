package com.gamu.Viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gabriel.longhi02@gmail.com");
        message.setTo("murilho2302@gmai.com");
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
