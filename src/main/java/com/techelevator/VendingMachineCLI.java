package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private VendingMachine myVendingMachine;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		myVendingMachine = new VendingMachine();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			// invoke the getChoiceFromOption method with that array we set up
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println();
				myVendingMachine.printInventory();

				// display vending machine items, our code will be here
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					System.out.println("Current Money Provided: $" + myVendingMachine.getTotalMoney());
					System.out.println();
					System.out.print("Please choose an option >>> ");
					Scanner userInput = new Scanner(System.in);
					String userChoice = userInput.nextLine();
					if (userChoice.equals("1")) {
						System.out.print("\nPlease enter the whole dollar amount you'd like to insert >>> ");
						String userMoney = userInput.nextLine();
						myVendingMachine.feedMoney(new BigDecimal(userMoney));
						myVendingMachine.writeToLog(dtf.format(now) + "    FEED MONEY:    $" + userMoney + "    $"
								+ myVendingMachine.getTotalMoney());
					} else if (userChoice.equals("2")) {
						System.out.print("\nPlease enter the code for your desired snack >>> ");
						String snackChoice = userInput.nextLine();
						if (myVendingMachine.selectProduct(snackChoice)) {
							myVendingMachine.writeToLog(
									dtf.format(now) + "    " + myVendingMachine.getProductInfo().getSnackName() + "    "
											+ snackChoice + "    $" + myVendingMachine.getProductInfo().getSnackPrice()
											+ "    $" + myVendingMachine.getTotalMoney());
						}
						System.out.println();

					} else if (userChoice.equals("3")) {
						myVendingMachine.writeToLog(dtf.format(now) + "    CHANGE GIVEN:    $"
								+ myVendingMachine.getTotalMoney() + "    $0.00");
						myVendingMachine.finishTransaction();
						break;
					}

				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				myVendingMachine.closeWriter();
				return;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // instantiate the menu object(giving it input source , output
														// source)
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		System.out.println("******************************");
		System.out.println("         VEND-O-MATIC\n             500");
		System.out.println("******************************");
		cli.run();
	}
}
