package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Machine {

    // Properties

    private int quantityRemaining;
    private Map<String, Queue> slots;
    private double machineBalance;
    private double inputMoney;

    // Constructors

    // Getters & Setters

    public int getQuantityRemaining() {
        return quantityRemaining;
    }
    public Map<String, Queue> getSlots() {
        return slots;
    }
    public double getMachineBalance() {
        return machineBalance;
    }
    public double getInputMoney() {
        return inputMoney;
    }

    // Other Methods
        // to add: vendItem(), update inputMoney / machineBalance

    // Creates a new Inventory object
    public void fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);
       // Places each queue (group of 5 snacks) into the map. Key is the slot location, value is the queue
       Map<String, Queue> myMap = new HashMap<>();
        for (Queue<VendingItem> queue : inventory.getQueues()) {
            myMap.put(queue.element().getLocation(), queue);
        }
    }

//    public String getMachineContents() {
//        System.out.println();
//
//    }


}