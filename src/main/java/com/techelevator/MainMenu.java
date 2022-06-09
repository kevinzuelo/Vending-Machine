package com.techelevator;

public class MainMenu extends Menu{




    @Override
    public void displayMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Make a choice : ");
    }

}
