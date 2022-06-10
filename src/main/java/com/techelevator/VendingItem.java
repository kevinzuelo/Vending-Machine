package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VendingItem {

    // Properties

    private String name;
    private BigDecimal price;
    private String message;
    private String type;
    private String location;

    // Constructors

    public VendingItem(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }
    public VendingItem(String location, String name, double price, String type ){
        this.location = location;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.type = type;
    }

    // Getters & setters

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
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

    public String printMessage() {
        if (type.equals("Chip")) {
            return "Crunch Crunch, Yum!";
        } else if (type.equals("Gum")) {
            return "Chewy Chewy, Yum!";
        } else if (type.equals("Drink")) {
            return "Slurp Slurp, Yum!";
        }
            return "Munch Munch, Yum!";
    }

}
