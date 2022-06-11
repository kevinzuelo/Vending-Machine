package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class Program {

	private static final String path = "vendingmachine.csv";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		int setChoice = 0;
		int purchaseChoice = 0;

		// Create Sales Log


		// Restock machine upon start up
		Inventory inventory = new Inventory();
		inventory.getInventory(path);
		Machine vendingMachine = new Machine();
		vendingMachine.fillMachine(path);

		// Display Main Menu options
			MainMenu mainMenu = new MainMenu();
			mainMenu.displayMenu();
			setChoice = Integer.parseInt(scanner.nextLine());
			mainMenu.choiceResponse(setChoice, vendingMachine.getSlots());

		// Display Purchase Menu options
		System.out.println();
		System.out.print("Please choose a menu option: ");
		purchaseChoice = Integer.parseInt(scanner.nextLine());
		purchaseMenu.choiceResponse(purchaseChoice, vendingMachine.getSlots(), vendingMachine, mainMenu);



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
