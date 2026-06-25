package com.tss.behavioural.observer.menu;

import com.tss.behavioural.observer.Validation.InputValidation;
import com.tss.behavioural.observer.service.AccountService;

public class NotificationType {
    AccountService accountService=new AccountService();
    public void NotificationMenu()
    {
        int choice = 0;
        do {
            System.out.println("1 for SMS");
            System.out.println("2 for Whatsapp");
            System.out.println("3 for Email");
            System.out.println("4 see notification service");
            System.out.println("5 for Exit");

            choice = InputValidation.readInt("Enter your Choice");
            switch (choice) {
                case 1:
                    accountService.addSMS();
                    break;
                case 2:
                    accountService.addWhatsapp();
                    break;
                case 3:
                    accountService.addEmail();
                    break;
                case 4:
                    accountService.DisplayNotification();
                    break;
                case 5:
                    System.out.println("Back Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}
