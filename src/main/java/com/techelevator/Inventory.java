package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private List<VendingItem> itemList = new ArrayList<>();
    private List<Queue> queues = new ArrayList<>();


    public List<VendingItem> getItemList() {
        return itemList;
    }

    public void getInventory(String path) {
        File inventoryFile = new File(path);
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                String itemLine = fileScanner.nextLine();
                String[] vendingItemProperties = itemLine.split(",");
                VendingItem item = new VendingItem(vendingItemProperties[0], vendingItemProperties[1], Double.parseDouble(vendingItemProperties[2]), vendingItemProperties[3]);
                itemList.add(item);
            }
            for (VendingItem item : itemList) {
                Queue<VendingItem> newLinkedList = new LinkedList<>();
                    for (int i = 0; i < 5; i++) {
                        newLinkedList.offer(item);
                    }
                queues.add(newLinkedList);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Go fish");
        }
    }



}
