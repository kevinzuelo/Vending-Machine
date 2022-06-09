package com.techelevator;

import java.util.Scanner;

public class Program {

	private static final String path = "vendingmachine.csv";

	public static void main(String[] args) {
		// Restock machine
		Inventory inventory = new Inventory();
		inventory.getInventory(path);
		Machine vendingMachine = new Machine();
		vendingMachine.fillMachine(path);

		Scanner scanner = new Scanner(System.in);


		MainMenu mainMenu = new MainMenu();
		mainMenu.displayMenu();
		mainMenu.setChoice(Integer.parseInt(scanner.nextLine()));


		System.out.println();
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		purchaseMenu.displayMenu();
		purchaseMenu.setChoice(Integer.parseInt(scanner.nextLine()));

		// Prompt user for account number
			// Prompt for how much money they want to add

		







		scanner.close();
	}
}
