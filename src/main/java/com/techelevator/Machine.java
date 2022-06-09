package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Machine {

    // Properties
    private int quantityRemaining;
    private Map<String, Queue> slots;
    private double machineBalance;
    private double inputMoney;

    // Constructors



    // Getters and Setters



    // Other Methods - vendItem(), update inputMoney / machineBalance, fillMachine

    public void fillMachine(String path){
       Inventory inventory = new Inventory();
       inventory.getInventory(path);

//       for (VendingItem item : inventory.getItemList()) {
//           String itemLocation = item.getLocation();
//                if (itemLocation.equals("A1"))
//       }
//
    }

}