package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class Machine {

    // Properties
    private Map<String, Queue> slots;
    private BigDecimal transactionBalance = BigDecimal.valueOf(0.00);

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
// Other Methods
        // to add: vendItem(), update inputMoney / machineBalance
    public VendingItem vendItem(String location) {
        Queue<VendingItem> temp = slots.get(location);
            BigDecimal itemPrice = (temp.element().getPrice());
            transactionBalance = transactionBalance.subtract(itemPrice);
            return (VendingItem)slots.get(location).poll();


    }
    // Creates a new Inventory object
    public Map<String, Queue> fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);
       // Places each queue (group of 5 snacks) into the map. Key is the slot location, value is the queue
        Map<String, Queue> myMap = new HashMap<>();
        for (Queue<VendingItem> queue : inventory.getQueues()) {
            myMap.put(queue.element().getLocation(), queue);
        }
        slots = myMap;
        return slots;
    }

    public VendingItem getFirstItem(String location) {
        return (VendingItem)slots.get(location).element();
    }

    public void calculateChange(BigDecimal remainingBalance) {
        BigDecimal change = remainingBalance;
        int numberOfQuarters = 0;
        int numberOfNickels = 0;
        int numberOfDimes = 0;

        for (BigDecimal i = change; i.compareTo(BigDecimal.valueOf(.25)) > 0 ; i = i.subtract(BigDecimal.valueOf(.25))) {
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

        System.out.println("Your Change is: " + numberOfQuarters + " quarters");
        System.out.println("Your Change is: " + numberOfDimes + " dimes");
        System.out.println("Your Change is: " + numberOfNickels + " nickels");


    }

}