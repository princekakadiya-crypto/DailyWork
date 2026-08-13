package com.tss.__jpa_app.service;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EMAIL")
@AllArgsConstructor
public class EmailNotificationServiceImpl implements NotificationService{

    private final JavaMailSender mailSender;

    @Override
    public void sendNotification(String message,String receiver) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("notify71845@gmail.com");
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject("OTP verification");
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

    }
}
