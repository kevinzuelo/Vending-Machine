package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Machine {

    // Properties
    private Map<String, Queue> slots;
    private BigDecimal transactionBalance = BigDecimal.valueOf(0.00);
    private final String PATH = System.getProperty("java.io.tmpdir") + "/SalesLog.txt";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m\t";
    public static final String ANSI_BLUE = "\u001B[34m";


    // Constructors

    // Getters & Setters
    public Map<String, Queue> getSlots() {
        return slots;
    }
    public BigDecimal getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(BigDecimal transactionBalance) {
        this.transactionBalance = this.transactionBalance.add(transactionBalance);
    }

    public VendingItem getFirstItem(String location) {
        return (VendingItem)slots.get(location).element();
    }

    // Other Methods

    // Takes input from user for slot location, subtracts price from machine balance, gives item to user
    public VendingItem vendItem(String location) throws IOException {
        Queue<VendingItem> temp = slots.get(location);
            BigDecimal itemPrice = (temp.element().getPrice());
            transactionBalance = transactionBalance.subtract(itemPrice);

            printToLog(temp.element().getName() + " " + location +  " $" + itemPrice +  " $"  + transactionBalance);

        // Removes one item from the queue to update inventory quantity
        return (VendingItem)slots.get(location).poll();
    }

    // Creates a new Inventory object
    public void fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);
       // Places each queue (group of 5 snacks) into the map. Key is the slot location, value is the queue
        Map<String, Queue> myMap = new LinkedHashMap<>();
        for (Queue<VendingItem> queue : inventory.getQueues()) {
            myMap.put(queue.element().getLocation(), queue);
        }
        slots = myMap;
    }

    // Takes amount left in machine and returns it to user in change, using smallest amount of coins
    public void calculateChange(BigDecimal remainingBalance) throws IOException {
        BigDecimal change = remainingBalance;
        int numberOfQuarters = 0;
        int numberOfNickels = 0;
        int numberOfDimes = 0;

        for (BigDecimal i = change; i.compareTo(BigDecimal.valueOf(.25)) >= 0 ; i = i.subtract(BigDecimal.valueOf(.25))) {
            numberOfQuarters++;
            change = change.subtract(BigDecimal.valueOf(.25));
        }
        for (BigDecimal i = change; i.compareTo(BigDecimal.valueOf(.10)) >= 0 ; i = i.subtract(BigDecimal.valueOf(.10))) {
            numberOfDimes++;
            change = change.subtract(BigDecimal.valueOf(.10));
        }
        for (BigDecimal i = change; i.compareTo(BigDecimal.valueOf(.05)) >= 0 ; i = i.subtract(BigDecimal.valueOf(.05))) {
            numberOfNickels++;
            change = change.subtract(BigDecimal.valueOf(.05));
        }
        System.out.println(ANSI_GREEN + "\nDispensing change. You received " + numberOfQuarters + " quarter(s), " + numberOfDimes + " dime(s), and " + numberOfNickels + " nickel(s)." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Thank you for your purchase. Returning to Main Menu." + ANSI_RESET);

        // Prints change amount given to Sales Log
        printToLog(" GIVE CHANGE: $" + getTransactionBalance() + " $" + change);
        setTransactionBalance(BigDecimal.valueOf(0).subtract(getTransactionBalance()));
    }

    // Basic method and message for printing to Sales Log
    public void printToLog(String message) throws IOException {
        File salesLog = new File(PATH);
            try (PrintWriter logWriter = new PrintWriter(new FileWriter(salesLog, true))) {
                String newLine = (LocalDateTime.now().format(DateTimeFormatter.ofPattern("\n MM/dd/yyyy HH:mm:ss a")) + " " + message);
                logWriter.append(newLine);
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }
}
