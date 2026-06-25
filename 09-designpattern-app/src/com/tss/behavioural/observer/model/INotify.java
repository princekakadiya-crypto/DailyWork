package com.tss.behavioural.observer.model;

public interface INotify {
    void sendNotification(String message,Account account);
    void display();
}
