package com.tss.behavioural.observer.model;

public class SMS implements INotify{
    @Override
    public void sendNotification(String message,Account account) {
        System.out.println("SMS");
        System.out.println("Mobile : "+account.getMobileNumber());
        System.out.println(message);
    }

    @Override
    public void display() {
        System.out.println("SMS notification Service");
    }
}
