package com.exampleateffigo.coursemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Online Course Management");
        message.setText("Hello " + username + ",\n\n" +
                "Thank you for registering at Online Course Management. We're excited to have you onboard!\n\n" +
                "Happy Learning!\nOnline Course Team");

        mailSender.send(message);
    }
}