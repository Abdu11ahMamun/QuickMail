package com.DevCraftLab.QuickMail.Service.impl;

import com.DevCraftLab.QuickMail.Service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("dev.abd.mamun@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        log.info("Multiple person got the email: "+message);
    }

    @Override
    public void sendEmailWithHTML(String to, String subject, String htmlContent) {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true,"UTF-8");
            helper.setFrom("dev.abd.mamun@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);
            mailSender.send(mimeMailMessage);
            log.info("HTML email has been sent!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);
            helper.setFrom("dev.abd.mamun@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(),file);
            mailSender.send(mimeMailMessage);
            log.info("Email with file has been sent!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, InputStream inStream) {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);
            helper.setFrom("dev.abd.mamun@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message, true);
            File file= new File("src/main/resources/email/test.png");
            Files.copy(inStream,file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(),file);
            mailSender.send(mimeMailMessage);
            log.info("Email with file has been sent!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
