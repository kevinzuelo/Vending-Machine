package com.techelevator;

import java.util.InputMismatchException;
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
		boolean isInvalidMain = true;
		do {
			MainMenu mainMenu = new MainMenu();
			mainMenu.displayMenu();
			try {
				setChoice = Integer.parseInt(scanner.nextLine());
				mainMenu.choiceResponse(setChoice, vendingMachine.getSlots(), vendingMachine);
				isInvalidMain = false;
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid choice.");
			}
		}
		while (isInvalidMain);

		// Display Purchase Menu options
		System.out.println();
		System.out.print("Please choose a menu option: ");


			try {
				purchaseChoice = Integer.parseInt(scanner.nextLine());
				purchaseMenu.choiceResponse(purchaseChoice, vendingMachine.getSlots(), vendingMachine);
			} catch (NumberFormatException e) {

				System.out.println("Invalid input. Please enter a valid choice.");
			}

		scanner.close();
	}
}
