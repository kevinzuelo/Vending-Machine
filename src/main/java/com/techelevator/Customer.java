package com.techelevator;

public class Customer {

    // Properties
    private String firstName;
    private int accountNumber;

    // Constructor

    public Customer(String firstName, int accountNumber) {
        this.firstName = firstName;
        this.accountNumber = accountNumber;
    }

    // Getters & setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Other methods


}
