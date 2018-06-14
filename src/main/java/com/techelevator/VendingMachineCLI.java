package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";// define a constant for a menu test
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";  //define a constant for a menu text
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";  //define a constant for a menu text

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, // define and array with menu choices
													   MAIN_MENU_OPTION_PURCHASE,
													   MAIN_MENU_OPTION_EXIT };
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			// invoke the getChoiceFromOption method with that array we set up
			
																			       //     with array of options
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items, our code will be here
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				return;
			}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out); // instantiate the menu object(giving it input source , output source)
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
