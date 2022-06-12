package com.techelevator;

public class Menu {

    // Properties

    private int choice;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m\t";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // Constructors

    // Getters & setters

    public int getChoice() {
        return choice;
    }

     public void setChoice(int choice) {
        this.choice = choice;
    }

    // Other methods

    public void displayMenu() {}

    public void displayItems() {}



}
