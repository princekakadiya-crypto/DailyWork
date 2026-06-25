package com.tss.behavioural.observer.menu;

import com.tss.behavioural.observer.Validation.InputValidation;
import com.tss.behavioural.observer.service.AccountService;

public class AccountMenu {
    AccountService accountService=new AccountService();
    NotificationType notificationType=new NotificationType();
    public void start() {
        int choice = 0;
        do {
            System.out.println("1 for Create Account");
            System.out.println("2 for Withdraw");
            System.out.println("3 for Deposit");
            System.out.println("4 for notification service");
            System.out.println("5 for Exit");

            choice = InputValidation.readInt("Enter your Choice");
            switch (choice) {
                case 1:
                    accountService.createAccount();
                    break;
                case 2:
                    accountService.deposit();
                    break;
                case 3:
                    accountService.withdraw();
                    break;
                case 4:
                    notificationType.NotificationMenu();
                    break;
                case 5:
                    System.out.println("Exited...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}
