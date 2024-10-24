package com.DevCraftLab.QuickMail.Controller;

import com.DevCraftLab.QuickMail.Service.EmailService;
import com.DevCraftLab.QuickMail.api.EmailRequest;
import com.DevCraftLab.QuickMail.api.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/email")
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmailWithHTML(request.getTo(),request.getSubject(),request.getMessage());
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email sent successfully!").status(HttpStatus.OK).success(true).build()
        );
    }
    @PostMapping("/send-with-file")
    public ResponseEntity<EmailResponse> sendFileWith(
            @RequestPart("file") MultipartFile file,
            @ModelAttribute EmailRequest request) throws IOException {
        emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(), file.getInputStream());
        return ResponseEntity.ok(
                EmailResponse.builder().message("Email sent successfully!").status(HttpStatus.OK).success(true).build()
        );
    }

}
