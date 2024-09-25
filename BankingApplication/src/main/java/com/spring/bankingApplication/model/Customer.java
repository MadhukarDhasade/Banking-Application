package com.spring.bankingApplication.model;

import com.spring.bankingApplication.bankService.CurrentAccount;
import com.spring.bankingApplication.bankService.SavingsAccount;

public class Customer {
    private String name; // Customer name
    private CurrentAccount currentAccount; // Current account instance
    private SavingsAccount savingsAccount; // Savings account instance

    public Customer(String name) {
        this.name = name;

        this.currentAccount = new CurrentAccount();
        this.savingsAccount = new SavingsAccount();
        // Credit savings account with joining bonus (R500)
        this.savingsAccount.deposit(500.0);
    }

    // Getters and setters
    public String getName() {
        return name; }

    public CurrentAccount getCurrentAccount() {
        return currentAccount; }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount; }
}
