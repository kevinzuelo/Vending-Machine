package com.techelevator;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VendingItem {

    // Properties

    private String name;
    private double price;
    private String message;
    private String type;
    private String location;

    // Constructors

    public VendingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public VendingItem(String location, String name, double price, String type ){
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    // Getters & setters

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getMessage() {
        return message;
    }
    public String getType() {
        return type;
    }
    public String getLocation() {
        return location;
    }

    // Other methods -- change message to fit each VendingItem type somehow

    public void getMessage(String type) {

    }




}
