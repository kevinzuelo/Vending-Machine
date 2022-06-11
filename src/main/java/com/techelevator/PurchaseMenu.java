package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class PurchaseMenu extends Menu{

    // Properties
    private String location;
    private static final String PATH = System.getProperty("java.io.tmpdir") + "/SalesLog.txt";
    public static File salesLog = new File(PATH);


    // Constructors

    // Getters & setters

    // Other methods
    public void choiceResponse(int choice, Map<String, Queue> stockedItems, Machine currentMachine) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (choice == 1) {

                System.out.print("\nEnter amount of dollars: ");
                BigDecimal numberOfDollars = BigDecimal.valueOf(Double.parseDouble(inputScanner.nextLine()));
                currentMachine.setTransactionBalance(numberOfDollars);
                System.out.println("\nCurrent amount provided: $ " + numberOfDollars.setScale(2, RoundingMode.CEILING));
                System.out.println("Total amount provided: $ " + currentMachine.getTransactionBalance().setScale(2, RoundingMode.CEILING));

                // Print money added to log
                currentMachine.printToLog(" FEED MONEY: $" + numberOfDollars + " $" + currentMachine.getTransactionBalance());


                System.out.println();
                displayMenu();
                System.out.print("Choose another menu option: ");
                int newChoice = inputScanner.nextInt();
                choiceResponse(newChoice, stockedItems, currentMachine);


            } else if (choice == 2) {
                for (Queue<VendingItem> queue : stockedItems.values()) {
                    System.out.println(queue.element().getLocation() + " || " + queue.element().getName() + " || $" + queue.element().getPrice().setScale(2, RoundingMode.CEILING) + " || Quantity Remaining: " + queue.size());
                }
                System.out.print("Choose Item Location: ");
                 location = inputScanner.nextLine();

                 if(currentMachine.getFirstItem(location).getPrice().compareTo(currentMachine.getTransactionBalance()) > 0) {
                     System.out.println("\nInsufficient funds, please insert more money.");
                     displayMenu();
                     System.out.print("Choose another menu option: ");
                     int newChoice = inputScanner.nextInt();
                     choiceResponse(newChoice, stockedItems, currentMachine);
                 }
                 else {
                     VendingItem thisItem = currentMachine.vendItem(location);
                     System.out.println("\nThe machine dispensed " + thisItem.getName() + "! \nCost: $" + thisItem.getPrice().setScale(2, RoundingMode.CEILING) + " \n***** " + thisItem.printMessage() +" *****\n" +
                             "Your remaining balance is: $" + currentMachine.getTransactionBalance().setScale(2, RoundingMode.CEILING));
                     displayMenu();
                     System.out.print("Choose another menu option: ");
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void displayMenu() {
        System.out.println("\n(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();

    }


}
