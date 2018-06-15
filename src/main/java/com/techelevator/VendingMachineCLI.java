package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";// define a constant
																									// for a menu test
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase"; // define a constant for a menu text
	private static final String MAIN_MENU_OPTION_EXIT = "Exit"; // define a constant for a menu text

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, // define and array with menu
																						// choices
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	private VendingMachine newVendingMachine;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		newVendingMachine = new VendingMachine();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			// invoke the getChoiceFromOption method with that array we set up
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println();
				newVendingMachine.printInventory();

				// display vending machine items, our code will be here
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					System.out.println("Current Money Provided: $" + newVendingMachine.getTotalMoney());
					System.out.println();
					System.out.print("Please choose an option >>> ");
					Scanner userInput = new Scanner(System.in);
					String userChoice = userInput.nextLine();
					if (userChoice.equals("1")) {
						System.out.print("Please enter the amount you'd like to insert >>> ");
						String userMoney = userInput.nextLine();
						newVendingMachine.feedMoney(new BigDecimal(userMoney));
						;
					} else if (userChoice.equals("2")) {
						System.out.print("Please enter the code for your desired snack >>> ");
						String snackChoice = userInput.nextLine();
						newVendingMachine.selectProduct(snackChoice);
						break;
					} else if (userChoice.equals("3")) {
						return;
					}

				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				return;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // instantiate the menu object(giving it input source , output
														// source)
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
