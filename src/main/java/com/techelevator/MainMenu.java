package com.techelevator;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MainMenu extends Menu{
    // Properties

    // Constructors

    // Getters & setters

    // Other methods

    // Method for menu choice response
    public void choiceResponse(int choice, Map<String, Queue> stockedItems) {
        Scanner inputScanner = new Scanner(System.in);
            if (choice == 1) {
                for (Queue<VendingItem> queue :  stockedItems.values()) {
                    System.out.println(queue.element().getLocation() + " || " + queue.element().getName() + " || " + queue.element().getPrice() + " || Quantity Remaining: " + queue.size());
                }
                displayMenu();
                int newChoice = inputScanner.nextInt();
                choiceResponse(newChoice, stockedItems);
            } else if (choice == 2) {
                PurchaseMenu purchaseMenu = new PurchaseMenu();
                purchaseMenu.displayMenu();
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3!");
                return;
            }

    }

    @Override
    public void displayMenu() {
        System.out.println("\n(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();
        System.out.print("Make a choice: ");

    }

}
