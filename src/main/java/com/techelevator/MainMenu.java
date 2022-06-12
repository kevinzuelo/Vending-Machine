package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.math.RoundingMode;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MainMenu extends Menu{
    // Properties


    // Constructors

    // Getters & setters

    // Other methods

    // Method for Main Menu choice response
    public void choiceResponse(int choice, Map<String, Queue> stockedItems, Machine currentMachine) {
            Scanner inputScanner = new Scanner(System.in);
              // Displays entire inventory with quantities remaining
              if (choice == 1) {
                for (Queue<VendingItem> queue : stockedItems.values()) {
                    System.out.println(ANSI_BLUE + queue.element().getLocation() + ANSI_RESET + " || " + queue.element().getName() + " || $" + queue.element().getPrice().setScale(2, RoundingMode.CEILING) + " || QTY Remaining: " + queue.size());
                }
                displayMenu();
                int newChoice = inputScanner.nextInt();
                choiceResponse(newChoice, stockedItems, currentMachine);
              // Displays Purchase Menu
            } else if (choice == 2) {
                    try {
                        PurchaseMenu purchaseMenu = new PurchaseMenu();
                        purchaseMenu.displayMenu();
                        System.out.print("Please choose a menu option: ");
                        choice = Integer.parseInt(inputScanner.nextLine());
                        purchaseMenu.choiceResponse(choice, stockedItems, currentMachine);
                    }
                    catch (Exception e) {
                        System.out.println(ANSI_RED + "\nInvalid input. Please enter a valid choice." + ANSI_RED);
                        choiceResponse(choice, stockedItems, currentMachine);
                    }
              // Exits machine and terminates program
            } else if (choice == 3) {
                System.out.println(ANSI_RED + "\nExiting Vending Machine.  Have a great day!" + ANSI_RESET);
                System.exit(0);
            } else {
                System.out.println(ANSI_RED + "\nInvalid choice. Please enter 1, 2, or 3!" + ANSI_RESET);
             }
    }

    // Display options for Main Menu
    @Override
    public void displayMenu() {
        System.out.println( ANSI_RED +
                "  _   _   _   _     _   _   _   _  \n" +
                " / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ \n" +
                "( " + ANSI_RESET + "M   A   I   N " + ANSI_RED + ") ( " + ANSI_RESET + "M   E   N   U " + ANSI_RED + ")\n" +
                " \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ " + ANSI_RESET);
        System.out.println("\n(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.print("\nPlease choose a menu option: ");
    }
}
