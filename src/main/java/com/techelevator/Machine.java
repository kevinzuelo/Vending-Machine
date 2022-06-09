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



    // Getters and Setters

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


    // Other Methods - vendItem(), update inputMoney / machineBalance, fillMachine

    public void fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);

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