package com.tss.__jpa_app.service;

import com.tss.__jpa_app.enums.Chanel;
import com.tss.__jpa_app.enums.Purpose;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationProcessor {
    private final Map<String,NotificationService> notificationServiceMap;
    private static final Logger log= LoggerFactory.getLogger(NotificationProcessor.class);

    public void send(Chanel chanel, String message, String receiver){

        log.info(notificationServiceMap.toString());

        NotificationService notificationService= notificationServiceMap.get(chanel.name());

        if (notificationService==null)
            throw new IllegalArgumentException("not found");

        notificationService.sendNotification(message, receiver);
    }

}
