package com.techelevator;

import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class PurchaseMenu extends Menu{

    // Properties

    // Constructors

    // Getters & setters

    // Other methods
    public void choiceResponse(int choice, Map<String, Queue> stockedMachine) {
        if (choice == 1) {
            try (Scanner moneyScanner = new Scanner(System.in)){
                System.out.print("Enter amount of dollars: ");
                double numberOfDollars = Double.parseDouble(moneyScanner.nextLine());
                System.out.println("Current amount provided: $ " + numberOfDollars);
                System.out.println();
                displayMenu();
                System.out.print("Make a choice: ");
                int newChoice = moneyScanner.nextInt();
                choiceResponse(newChoice, stockedMachine);


            }

        }
        else if (choice == 2) {
            for(Queue <VendingItem> queue : stockedMachine.values()){
                System.out.println(queue.element().getLocation() + " || " + queue.element().getName() +  " || " + queue.element().getPrice() + " || Quantity Remaining: " + queue.size());

            }
        }
        else if (choice == 3) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid choice. Please enter 1, 2, or 3!");
            return;
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
