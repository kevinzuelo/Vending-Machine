package com.techelevator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	private static final String path = "vendingmachine.csv";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m\t";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PurchaseMenu purchaseMenu = new PurchaseMenu();
		int setChoice = 0;
		int purchaseChoice = 0;

		// Restock machine to full upon start up
		Inventory inventory = new Inventory();
		inventory.getInventory(path);
		Machine vendingMachine = new Machine();
		vendingMachine.fillMachine(path);

		// Display Main Menu options
		System.out.println();
		System.out.println(ANSI_CYAN + "******************" + ANSI_RESET + "  WELCOME TO THE  " + ANSI_CYAN + "*****************" + ANSI_RESET);
		System.out.println(ANSI_BLUE +
				"              █                   █                   \n" +
				"█ █           █     █   █      █          ███ ███ ███ \n" +
				"█ █ ███ ███ ███ ███ ██ ██ ███ ███ █ ███   █ █ ███ ███ \n" +
				"█ █ ███ █ █ █ █ █ █ █ █ █   █  █  █ █     ███ █ █ █ █ \n" +
				"█ █ █   █ █ █ █ █ █ █   █ ███  █  █ █     █ █ ███ ███ \n" +
				" █  ███ █ █ ███ ███ █   █ ███  ██ █ ███   ███ ███ ███ " + ANSI_RESET);
		System.out.println(ANSI_CYAN + "*****************************************************\n" + ANSI_RESET);

		boolean isInvalidMain = true;
		do {
			MainMenu mainMenu = new MainMenu();
			mainMenu.displayMenu();
			try {
				setChoice = Integer.parseInt(scanner.nextLine());
				mainMenu.choiceResponse(setChoice, vendingMachine.getSlots(), vendingMachine);
				isInvalidMain = false;
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println(ANSI_RED + "\nInvalid input. Please enter a valid choice." + ANSI_RESET);
			}
		}
		while (isInvalidMain);

		// Display Purchase Menu options
		System.out.println();
		System.out.print("Please choose a menu option:");

			try {
				purchaseChoice = Integer.parseInt(scanner.nextLine());
				purchaseMenu.choiceResponse(purchaseChoice, vendingMachine.getSlots(), vendingMachine);
			} catch (NumberFormatException e)  {
				System.out.println(ANSI_RED + "\nInvalid input. Please enter a valid choice." + ANSI_RESET);
			} catch (Exception e) {
				purchaseMenu.displayMenu();

			}

		scanner.close();
	}
}
