package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.model.Customer;
import com.spring.bankingApplication.model.Transaction;

public class NotificationSystem {

    public void sendNotification(Transaction transaction, Customer customer) {
        System.out.println("Notification sent to " + customer.getName() + ": " + transaction.getType() + " of " + transaction.getAmount());
    }
}

