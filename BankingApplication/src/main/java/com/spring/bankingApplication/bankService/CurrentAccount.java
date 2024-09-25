package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.bankAbstract.Account;

public class CurrentAccount extends Account {


    public void payOtherAccount(double amount, Account recipientAccount) {
        withdraw(amount); // Withdraw from this account
        recipientAccount.deposit(amount); // Deposit into recipient account
    }

}
