package com.techelevator;

import java.math.BigDecimal;

public class VendingItem {

    // Properties

    private String name;
    private BigDecimal price;
    private String type;
    private String location;

    // Constructors

    public VendingItem() { }

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
    public String getType() {
        return type;
    }
    public String getLocation() {
        return location;
    }

    // Other methods

    // Print specialized message for each item type
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
