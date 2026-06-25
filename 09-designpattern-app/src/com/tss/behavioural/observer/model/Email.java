package com.tss.behavioural.observer.model;

public class Email implements INotify{
    @Override
    public void sendNotification(String message, Account account) {
        System.out.println("Email");
        System.out.println("Email : "+account.getEmail());
        System.out.println(message);
    }

    @Override
    public void display() {
        System.out.println("Email notification Service");
    }
}
