package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.exceptionHandling.CustomerNotFound;
import com.spring.bankingApplication.model.Customer;
import com.spring.bankingApplication.model.Transaction;

import java.util.List;

public interface BankingApplicationService {
    public List<Customer> showCustomers();
    public void createCustomer(String name);
    public void depositToCurrent(double amount);
    public void depositToSaving(double amount);
    public void TransferToOthers(Double amount);
    public void TransferFromSaving(Double amount);
    public void sendNotificationCurrent();
    public void sendNotificationSaving();
    public List<Transaction> showSavingTrans(String name) throws CustomerNotFound;
    public List<Transaction> showCurrentTrans(String name) throws CustomerNotFound;
    public int selectCustomer(String name) throws CustomerNotFound;
}
