package com.techelevator;

public class VendingItem {

    // Properties
    private String name;
    private double price;
    private String message;
    private String type;

    // Constructors

    public VendingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }


    // Getters and setters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    // Other methods -- change message to fit VendingItem type somehow

    public void getMessage(String type) {

    }


}
