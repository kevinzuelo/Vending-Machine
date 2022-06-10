package com.techelevator;

import java.util.Scanner;

public class Program {

	private static final String path = "vendingmachine.csv";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Restock machine upon start up
		Inventory inventory = new Inventory();
		inventory.getInventory(path);
		Machine vendingMachine = new Machine();
		vendingMachine.fillMachine(path);

		// Display Main Menu options
		MainMenu mainMenu = new MainMenu();
		mainMenu.displayMenu();
		mainMenu.setChoice(Integer.parseInt(scanner.nextLine()));

		// Display Purchase Menu options
		System.out.println();
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		purchaseMenu.displayMenu();
		purchaseMenu.setChoice(Integer.parseInt(scanner.nextLine()));

		// Prompt user for account number
		// Prompt for how much money they want to add (whole dollar amounts)
		// Greet customer and display how much money they've added (inputMoney)

		// Display all products

		// Prompt customer to choose a slot

		// Dispense item. Show name, cost, and yum yum message.
		// Display customer's updated balance

		// Options: Return to main menu? Or ask them if they want to make another purchase?

		// If they're finished, print transactions to Sales Log
		// Give customer their change


		scanner.close();
	}
}
