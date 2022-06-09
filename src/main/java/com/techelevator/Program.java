package com.techelevator;

import java.util.Scanner;

public class Program {

	private static final String path = "vendingmachine.csv";

	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		inventory.getInventory(path);


//		Machine vendingMachine = new Machine();
//		vendingMachine.fillMachine(path);

		Scanner scanner = new Scanner(System.in);

		MainMenu mainMenu = new MainMenu();
		mainMenu.displayMenu();
		mainMenu.setChoice(Integer.parseInt(scanner.nextLine()));

		System.out.println();
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		purchaseMenu.displayMenu();
		purchaseMenu.setChoice(Integer.parseInt(scanner.nextLine()));










		scanner.close();
	}
}
