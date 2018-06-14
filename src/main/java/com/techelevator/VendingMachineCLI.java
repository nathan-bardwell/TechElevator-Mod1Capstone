package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

<<<<<<< HEAD
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";// define a constant for a menu test
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";  //define a constant for a menu text
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";  //define a constant for a menu text

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, // define and array with menu choices
													   MAIN_MENU_OPTION_PURCHASE,
													   MAIN_MENU_OPTION_EXIT };
=======
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";    //Define a constant for  menu text
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";                              //Define a constant for menu text
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,              //Define an array with menu choices
													   MAIN_MENU_OPTION_PURCHASE,
													   MAIN_MENU_OPTION_EXIT};
>>>>>>> 4664763f1c2f806fdce4bb99f662a5ab8448c9a4
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		while(true) {
<<<<<<< HEAD
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			// invoke the getChoiceFromOption method with that array we set up
			
=======
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);    //Invoke the getChoiceFromOptions method
																			       //     with array of options
>>>>>>> 4664763f1c2f806fdce4bb99f662a5ab8448c9a4
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
<<<<<<< HEAD
		Menu menu = new Menu(System.in, System.out); // instantiate the menu object(giving it input source , output source)
=======
		Menu menu = new Menu(System.in, System.out);                                 //Instantiate menu object (input-src, output-src)
>>>>>>> 4664763f1c2f806fdce4bb99f662a5ab8448c9a4
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
