package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    // Properties

    private List<VendingItem> itemList = new ArrayList<>();
    private List<Queue> queues = new ArrayList<>();

    // Constructors

    // Getters & setters

    public List<VendingItem> getItemList() { return itemList; }

    public List<Queue> getQueues() {
        return queues;
    }

    // Other methods

    public void getInventory(String path) {
        // Pull inventory list from .csv file one line at a time
        File inventoryFile = new File(path);
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                // Split line & add to String array
                String[] vendingItemProperties = itemLine.split(",");
                // String array becomes VendingItem object
                VendingItem item = new VendingItem(vendingItemProperties[0], vendingItemProperties[1], Double.parseDouble(vendingItemProperties[2]), vendingItemProperties[3]);
                // VendingItem object gets added to VendingItem list
                itemList.add(item);
            }
            // Each VendingItem list is added to a queue 5 times
            for (VendingItem item : itemList) {
                Queue<VendingItem> newLinkedList = new LinkedList<>();
                    for (int i = 0; i < 5; i++) {
                        newLinkedList.offer(item);
                    }
                // Queue is then added to the list of queues
                queues.add(newLinkedList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input a valid inventory file.");
            getInventory(path);
        }
    }

}
