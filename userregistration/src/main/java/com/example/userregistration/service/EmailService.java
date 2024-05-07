package com.example.userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;*/
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetPasswordEmail(String email, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset Your Password");
        message.setText("To reset your password, please click the link below:\n\n" + resetLink);
        mailSender.send(message);
    }
}