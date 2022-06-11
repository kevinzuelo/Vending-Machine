package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.math.MathContext;
import java.math.RoundingMode;
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

    public void choiceResponse(int choice, Map<String, Queue> stockedItems, Machine currentMachine) {
            Scanner inputScanner = new Scanner(System.in);
              if (choice == 1) {
                for (Queue<VendingItem> queue : stockedItems.values()) {
                    System.out.println(queue.element().getLocation() + " || " + queue.element().getName() + " || $" + queue.element().getPrice().setScale(2, RoundingMode.CEILING) + " || Quantity Remaining: " + queue.size());
                }
                displayMenu();
                int newChoice = inputScanner.nextInt();
                choiceResponse(newChoice, stockedItems, currentMachine);
            } else if (choice == 2) {
                  boolean isInvalidPurchase = true;
                  do {
                    try {
                        PurchaseMenu purchaseMenu = new PurchaseMenu();
                        purchaseMenu.displayMenu();
                        System.out.print("Please choose a menu option: ");
                        choice = Integer.parseInt(inputScanner.nextLine());
                        purchaseMenu.choiceResponse(choice, stockedItems, currentMachine);
                    }
                    catch (Exception e) {
                        isInvalidPurchase = true;
                        System.out.println("Invalid input. Please enter a valid choice.");
                    }
                } while (isInvalidPurchase);

            } else if (choice == 3) {
                System.out.println("\nExiting Vending Machine.  Have a great day!");
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
        System.out.print("\nPlease choose a menu option: ");
    }

}
