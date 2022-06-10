package com.techelevator;

import java.util.*;

public class Machine {

    // Properties
    private Map<String, Queue> slots;
    private double transactionBalance;

    // Constructors

    // Getters & Setters

    public Map<String, Queue> getSlots() {
        return slots;
    }

    public double getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(double transactionBalance) {
        this.transactionBalance += transactionBalance;
    }
// Other Methods
        // to add: vendItem(), update inputMoney / machineBalance
    public VendingItem vendItem(String location) {
        Queue<VendingItem> temp = slots.get(location);
            double itemPrice = temp.element().getPrice();
            transactionBalance -= itemPrice;
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

}