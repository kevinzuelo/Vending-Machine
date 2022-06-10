package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
public class PurchaseMenu extends Menu{

    // Properties
    private String location;
    // Constructors

    // Getters & setters

    // Other methods
    public void choiceResponse(int choice, Map<String, Queue> stockedItems, Machine currentMachine) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (choice == 1) {

                System.out.print("Enter amount of dollars: ");
                BigDecimal numberOfDollars = BigDecimal.valueOf(Double.parseDouble(inputScanner.nextLine()));
                currentMachine.setTransactionBalance(numberOfDollars);
                System.out.println("Current amount provided: $ " + numberOfDollars);
                System.out.println("Total amount provided: $ " + currentMachine.getTransactionBalance());
                System.out.println();
                displayMenu();
                System.out.print("Make a choice: ");
                int newChoice = inputScanner.nextInt();
                choiceResponse(newChoice, stockedItems, currentMachine);


            } else if (choice == 2) {
                for (Queue<VendingItem> queue : stockedItems.values()) {
                    System.out.println(queue.element().getLocation() + " || " + queue.element().getName() + " || " + queue.element().getPrice() + " || Quantity Remaining: " + queue.size());
                }
                System.out.print("Choose Item Location: ");
                 location = inputScanner.nextLine();

                 if(currentMachine.getFirstItem(location).getPrice().compareTo(currentMachine.getTransactionBalance()) > 0) {
                     System.out.println("Insufficient funds, please insert more money.");
                     displayMenu();
                     System.out.print("Make a choice: ");
                     int newChoice = inputScanner.nextInt();
                     choiceResponse(newChoice, stockedItems, currentMachine);
                 }
                 else {
                     VendingItem thisItem = currentMachine.vendItem(location);
                     System.out.println(thisItem.getName() + " " + thisItem.getPrice() + " " + thisItem.printMessage() +"\n" +
                             "Remaining balance in machine: " + currentMachine.getTransactionBalance());
                     displayMenu();
                     System.out.print("Make a choice: ");
                     int newChoice = inputScanner.nextInt();
                     choiceResponse(newChoice, stockedItems, currentMachine);
                 }

            } else if (choice == 3) {
                currentMachine.calculateChange(currentMachine.getTransactionBalance());
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3!");
                return;
            }
        }
        catch (NoSuchElementException e) {

        }
    }
    @Override
    public void displayMenu() {
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();

    }


}
