package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PurchaseMenu extends Menu{

    // Properties
    private String location;
    private static final String PATH = System.getProperty("java.io.tmpdir") + "/SalesLog.txt";
    public static File salesLog = new File(PATH);
    private VendingItem oneLeft = new VendingItem();

    // Constructors

    // Getters & setters

    // Other methods
    public void choiceResponse(int choice, Map<String, Queue> stockedItems, Machine currentMachine) throws NoSuchElementException{
        try (Scanner inputScanner = new Scanner(System.in)) {
            // Feed Money option
            if (choice == 1) {
                try {
                    System.out.print("\nEnter amount of dollars: ");
                    BigDecimal numberOfDollars = BigDecimal.valueOf(Integer.parseInt(inputScanner.nextLine()));
                    BigDecimal zeroDollars = BigDecimal.valueOf(0);
                    if (numberOfDollars.compareTo(zeroDollars) > 0) {
                        currentMachine.setTransactionBalance(numberOfDollars);
                        System.out.println(ANSI_GREEN + "\nCurrent amount provided: $ " + numberOfDollars.setScale(2, RoundingMode.CEILING));
                        System.out.println("Total amount provided: $ " + currentMachine.getTransactionBalance().setScale(2, RoundingMode.CEILING) + ANSI_RESET);
                    }
                    else {
                        System.out.println(ANSI_RED + "\nPlease enter a positive dollar amount!" + ANSI_RESET);
                    }

                    // Amount of money fed to machine added to Sales Log
                    currentMachine.printToLog(" FEED MONEY: $" + numberOfDollars + " $" + currentMachine.getTransactionBalance());
                    // Goes back to Purchase Menu
                    displayMenu();
                    System.out.print("Choose another menu option: ");
                    choice = inputScanner.nextInt();
                    choiceResponse(choice, stockedItems, currentMachine);
                } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED + "\nPlease enter a valid dollar amount." + ANSI_RESET);
                    choiceResponse(choice, stockedItems, currentMachine);
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "\nError, please try again." + ANSI_RESET);
                    choiceResponse(choice, stockedItems, currentMachine);
                }
              // Purchase option: shows inventory list with quantities remaining
            } else if (choice == 2) {
                    for (Queue<VendingItem> queue : stockedItems.values()) {
                        // If there is only one item left of a particular item, that item gets temporarily saved to the oneLeft variable
                        if(queue.size() == 1) {
                            oneLeft = queue.element();
                            System.out.println(ANSI_BLUE + queue.element().getLocation() +ANSI_RESET+ " || " + queue.element().getName() + " || $" + queue.element().getPrice().setScale(2, RoundingMode.CEILING) + " || Quantity Remaining: " + queue.size());
                        }
                        // If user attempts to purchase an item after it is depleted, display sold out message
                        else if(queue.size() == 0) {
                            System.out.println(ANSI_BLUE+ oneLeft.getLocation() +ANSI_RESET+ " || " + oneLeft.getName() + " || $" + oneLeft.getPrice().setScale(2, RoundingMode.CEILING) + " || Quantity Remaining: " + "SOLD OUT");
                        }
                        else {
                            System.out.println(ANSI_BLUE+ queue.element().getLocation() +ANSI_RESET+ " || " + queue.element().getName() + " || $" + queue.element().getPrice().setScale(2, RoundingMode.CEILING) + " || Quantity Remaining: " + queue.size());
                        }
                    }
                    System.out.print("Choose Item Location: ");
                        // Gets user input for item choice
                        location = inputScanner.nextLine().toUpperCase();
                        // Give error if they put in an invalid item location
                        if (!stockedItems.containsKey(location.toUpperCase())) {
                            System.out.println(ANSI_RED + "\nInvalid choice, try again. \n" + ANSI_RESET);
                            choiceResponse(choice, stockedItems, currentMachine);
                        }
                        // Give error if they don't have enough money to purchase item. Shows inventory list again.
                        if (currentMachine.getFirstItem(location).getPrice().compareTo(currentMachine.getTransactionBalance()) > 0) {
                         System.out.println(ANSI_RED + "\nInsufficient funds, please insert more money." + ANSI_RESET);
                         displayMenu();
                         System.out.print("Choose another menu option: ");
                         choice = inputScanner.nextInt();
                         choiceResponse(choice, stockedItems, currentMachine);
                         }
                        // Vends item and displays name, price, special message, and remaining balance in machine
                        else {
                         VendingItem thisItem = currentMachine.vendItem(location);
                         System.out.println(ANSI_BLUE+ "\nThe machine dispensed " + thisItem.getName() + "!"+ANSI_RESET+ANSI_GREEN+"\nCost: $" + thisItem.getPrice().setScale(2, RoundingMode.CEILING) +ANSI_BLUE+ " \n***** " + thisItem.printMessage() + " *****\n" +
                                 ANSI_GREEN+ "\nYour remaining balance is: $" + currentMachine.getTransactionBalance().setScale(2, RoundingMode.CEILING)+ANSI_RESET);
                         displayMenu();
                         // Returns to Purchase Menu
                         System.out.print("Choose another menu option: ");
                         choice = inputScanner.nextInt();
                         choiceResponse(choice, stockedItems, currentMachine);
                        }


            } else if (choice == 3) {
                // Give change to user, reset Machine Balance to 0, return to Main Menu
                MainMenu mainMenu = new MainMenu();
                currentMachine.calculateChange(currentMachine.getTransactionBalance());
                mainMenu.displayMenu();
                choice = inputScanner.nextInt();
                mainMenu.choiceResponse(choice, stockedItems, currentMachine);
            } else {
                try {
                    System.out.println(ANSI_RED + "\nInvalid choice. Please enter 1, 2, or 3!" + ANSI_RESET);
                    return;
                }
                catch (NoSuchElementException e) {
                }
            }
        }
        catch (NoSuchElementException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Display options for Purchase Menu
    @Override
    public void displayMenu() {
        System.out.println(ANSI_YELLOW + "\n" +
                "  _   _   _   _   _   _   _   _     _   _   _   _  \n" +
                " / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ \n" +
                "( " + ANSI_RESET + "P   U   R   C   H   A   S   E" + ANSI_YELLOW + " ) ( " + ANSI_RESET + "M   E   N   U " + ANSI_YELLOW + ")\n" +
                " \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ " + ANSI_RESET);
        System.out.println("\n(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();
    }

}
