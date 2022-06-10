package com.techelevator;

import java.util.List;
import java.util.Queue;

public class MainMenu extends Menu{
    // Properties

    // Constructors

    // Getters & setters

    // Other methods

    // Method for menu choice response
    public void choiceResponse() {
        if (getChoice() == 1) {

    // display all items including quantity remaining
//            Inventory inventory = new Inventory();
//            Queue<VendingItem> queue = inventory.getQueues();
        }
        else if (getChoice() == 2) {
            PurchaseMenu purchaseMenu = new PurchaseMenu();
            purchaseMenu.displayMenu();
        }
        else if (getChoice() == 3) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid choice. Please enter 1, 2, or 3!");
            choiceResponse();
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Make a choice : ");
    }

}
