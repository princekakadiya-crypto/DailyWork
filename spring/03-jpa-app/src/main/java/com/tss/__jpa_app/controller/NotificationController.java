package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.enums.Chanel;
import com.tss.__jpa_app.service.NotificationProcessor;
import com.tss.__jpa_app.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationProcessor notificationProcessor;

    @PostMapping("/notify")
    public void sendNotification(@RequestParam(required = false) Chanel type, @RequestParam String message, @RequestParam String receiver){
        if (type==null){
            notificationService.sendNotification(message,receiver);
            return;
        }

        notificationProcessor.send(type,message, receiver);
    }
}
