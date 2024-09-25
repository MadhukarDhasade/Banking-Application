package com.spring.bankingApplication.model;

/**
 * Represents a transaction.
 */
public class Transaction {
    private String type; // Transaction type (deposit/withdrawal)
    private double amount; // Transaction amount

    /**
     * Constructs a new Transaction object.
     *
     * @param type  Transaction type
     * @param amount Transaction amount
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getters and setters
    public String getType() {
        return type; } // Return transaction type
    public double getAmount() {
        return amount; } // Return transaction amount
}
