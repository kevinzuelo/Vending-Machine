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

    public void setMachineBalance(double machineBalance) {
        this.machineBalance = machineBalance;
    }

    public void setInputMoney(double inputMoney) {
        this.inputMoney += inputMoney;
    }
// Other Methods
        // to add: vendItem(), update inputMoney / machineBalance
    public VendingItem vendItem(String location) {










        Object object = slots.get(location).poll();
        VendingItem vendedItem = new VendingItem();
        return vendedItem;
    }
    // Creates a new Inventory object
    public Map<String, Queue> fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);
       // Places each queue (group of 5 snacks) into the map. Key is the slot location, value is the queue
        Map<String, Queue> myMap = new HashMap<>();
        for (Queue<VendingItem> queue : inventory.getQueues()) {
            myMap.put(queue.element().getLocation(), queue);

        }slots = myMap;
        return slots;
    }

//    public String getMachineContents() {
//        System.out.println();
//
//    }


}