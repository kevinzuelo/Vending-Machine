package com.techelevator;

public class VendingItems {

    // Properties
    private String name;
    private double price;
    private String message;
    private String type;

    // Constructors

    public VendingItems(String name, double price) {
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


    // Other methods

    public void getMessage(String type) {

    }


}
