package com.tss.__jpa_app.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("SMS")
@Primary
public class SMSServiceImpl implements NotificationService{
    @Override
    public void sendNotification(String message,String receiver) {
        System.out.println(message+" send by SMS to : "+receiver);
    }
}
