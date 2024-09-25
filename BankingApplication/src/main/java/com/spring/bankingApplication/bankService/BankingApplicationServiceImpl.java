package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.exceptionHandling.CustomerNotFound;
import com.spring.bankingApplication.model.Customer;
import com.spring.bankingApplication.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingApplicationServiceImpl implements  BankingApplicationService {
    private List<Customer> customers; // List of customers
    BankingApplication app = new BankingApplication();

    public List<Customer> showCustomers(){
        return  app.customers;
    }

    public void createCustomer(String name) {
        app.createCustomer(name);
    }
    public void depositToCurrent(double amount){
        Customer customer = app.customers.get(0);
        CurrentAccount currentAccount = customer.getCurrentAccount();
        currentAccount.deposit(amount); // Deposit R1000 into current account
        sendNotificationCurrent();
    }
    public void depositToSaving(double amount){
        Customer customer = app.customers.get(0);
        SavingsAccount savingsAccount = customer.getSavingsAccount();
        savingsAccount.deposit(amount); // Deposit R500 into savings account
        sendNotificationSaving();
    }

    public void TransferToOthers(Double amount) {
        Customer customer = app.customers.get(0);
        SavingsAccount savingsAccount = customer.getSavingsAccount();
        CurrentAccount currentAccount = customer.getCurrentAccount();
        currentAccount.payOtherAccount(amount, savingsAccount);// Pay R200 from current to savings
        sendNotificationCurrent();
    }
    public void TransferFromSaving(Double amount) {
        Customer customer = app.customers.get(0);
        CurrentAccount currentAccount = customer.getCurrentAccount();
        SavingsAccount savingsAccount = customer.getSavingsAccount();
        savingsAccount.payOtherAccount(amount, currentAccount);
        sendNotificationCurrent();
    }

    public void sendNotificationCurrent(){
        Customer customer = app.customers.get(0);
        CurrentAccount currentAccount = customer.getCurrentAccount();
        NotificationSystem notificationSystem = new NotificationSystem();
        notificationSystem.sendNotification(currentAccount.getTransactions().get(currentAccount.getTransactions().size()-1), customer); // Send notification for each transaction
    }

    public void sendNotificationSaving(){
        Customer customer = app.customers.get(0);
        SavingsAccount savingsAccount = customer.getSavingsAccount();
        NotificationSystem notificationSystem = new NotificationSystem();
        notificationSystem.sendNotification(savingsAccount.getTransactions().get(savingsAccount.getTransactions().size()-1), customer);
    }

    public List<Transaction> showSavingTrans(String name) throws CustomerNotFound {
        Customer customer = app.customers.get(selectCustomer(name));
        SavingsAccount savingsAccount = customer.getSavingsAccount();
        return  savingsAccount.getTransactions();
    }

    public List<Transaction> showCurrentTrans(String name) throws CustomerNotFound {
        Customer customer = app.customers.get(selectCustomer(name));
        CurrentAccount currentAccount = customer.getCurrentAccount();
        return  currentAccount.getTransactions();
    }

    public int selectCustomer(String name) throws CustomerNotFound {
        int i = 0 ;
        int j =app.customers.size();
        for (Customer customer : app.customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                break;
            }
            else{
                i++;
            }
        }
        if (i==j) {
            throw new CustomerNotFound("Customer Not Found");
        }
        else{
        return i;}
    }
}
