package com.spring.bankingApplication.bankService;

import com.spring.bankingApplication.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class BankingApplication {
    public List<Customer> customers; // List of customers

    public BankingApplication() {
        this.customers = new ArrayList<>(); // Initialize customer list
    }
    public void createCustomer(String name) {
        Customer customer = new Customer(name); // Create customer object
        customers.add(customer); // Add to customer list
    }
}
