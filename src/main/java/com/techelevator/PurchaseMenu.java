package com.techelevator;

import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

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
                double numberOfDollars = Double.parseDouble(inputScanner.nextLine());
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
                System.out.println(currentMachine.vendItem(location).getName() + " Updated Balance: " + currentMachine.getTransactionBalance());
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3!");
                return;
            }
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
