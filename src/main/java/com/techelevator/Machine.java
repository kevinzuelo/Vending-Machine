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
        File inventoryFile = new File(path);
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                String[] vendingItemProperties = itemLine.split(",");
                VendingItem item = new VendingItem(vendingItemProperties[0], vendingItemProperties[1], Integer.parseInt(vendingItemProperties[2]), vendingItemProperties[3]);

            }


        } catch (FileNotFoundException e) {
            System.out.println("Go fish");
        }



    }

}