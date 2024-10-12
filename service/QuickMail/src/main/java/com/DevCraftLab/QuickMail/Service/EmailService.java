package com.DevCraftLab.QuickMail.Service;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
    //send email to single person
    void sendEmail(String to, String subject, String message);
    //send to multiple person
    void sendEmail(String[] to, String subject, String message);
    //sendEmailWithHTML
    void sendEmailWithHTML(String to, String subject, String htmlContent);
    //send mail with file
    void sendEmailWithFile(String to, String subject, String message, File file);
    void sendEmailWithFile(String to, String subject, String message, InputStream inStream);
}
