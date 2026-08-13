package com.tss.__jpa_app.service;

import org.springframework.stereotype.Service;

@Service("WHATSAPP")
public class WhatsappNotificationServiceImpl implements NotificationService{
    @Override
    public void sendNotification(String message, String receiver) {
        System.out.println(message+" send by Whatsapp to : "+receiver);
    }
}
