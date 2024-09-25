package com.spring.bankingApplication.bankAbstract;

import com.spring.bankingApplication.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected double balance; // Account balance
    protected List<Transaction> transactions; // Transaction history


    public Account() {
        this.balance = 0.0; // Initialize balance to 0
        this.transactions = new ArrayList<>(); // Initialize transaction history
    }

    public void deposit(double amount) {
        balance += amount; // Update balance
        transactions.add(new Transaction("Deposit", amount)); // Record transaction
    }


    public void withdraw(double amount) {
        balance -= amount; // Update balance
        balance-=amount*0.0005;
        transactions.add(new Transaction("Withdrawal", amount)); // Record transaction
    }


    public double getBalance() {
        return balance;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

}
