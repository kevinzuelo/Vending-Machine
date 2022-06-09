package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {



    List<VendingItem> itemList = new ArrayList<>();

    public void getInventory(String path) {
        File inventoryFile = new File(path);
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                String[] vendingItemProperties = itemLine.split(",");
                VendingItem item = new VendingItem(vendingItemProperties[0], vendingItemProperties[1], Double.parseDouble(vendingItemProperties[2]), vendingItemProperties[3]);
                itemList.add(item);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Go fish");
        }
    }
}
