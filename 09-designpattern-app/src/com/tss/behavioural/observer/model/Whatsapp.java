package com.tss.behavioural.observer.model;

public class Whatsapp implements INotify{
    @Override
    public void sendNotification(String message, Account account) {
        System.out.println("Whatsapp");
        System.out.println("Mobile : "+account.getMobileNumber());
        System.out.println(message);
    }

    @Override
    public void display() {
        System.out.println("Whatsapp notification Service");
    }
}
