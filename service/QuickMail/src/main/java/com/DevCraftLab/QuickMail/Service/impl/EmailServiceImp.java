package com.DevCraftLab.QuickMail.Service.impl;

import com.DevCraftLab.QuickMail.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImp implements EmailService {
    private JavaMailSender mailSender;
    private Logger log = LoggerFactory.getLogger(EmailServiceImp.class);

    public EmailServiceImp(JavaMailSender mailSender){
        this.mailSender= mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("dev.abd.mamun@gmail.com");
        mailSender.send(simpleMailMessage);
        log.info("Email has been sent!!");

    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

    }

    @Override
    public void sendEmailWithHTML(String to, String subject, String htmlContent) {

    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {

    }
}
