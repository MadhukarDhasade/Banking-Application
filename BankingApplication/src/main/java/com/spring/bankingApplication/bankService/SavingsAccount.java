package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.bankAbstract.Account;

public class SavingsAccount extends Account {
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        balance += balance * 0.005; // Add 0.5% interest
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
    public void payOtherAccount(double amount, Account recipientAccount) {
        withdraw(amount); // Withdraw from this account
        recipientAccount.deposit(amount); // Deposit into recipient account
    }
}
