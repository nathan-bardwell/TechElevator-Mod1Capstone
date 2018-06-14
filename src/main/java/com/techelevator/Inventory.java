package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Inventory {

	HashMap<String, Snack> snackMap = new HashMap<String, Snack>();

	public Inventory()  {

	}

	File inventoryFile = new File("vendingmachine.csv");
	public HashMap<String, Snack> fillInventory() throws  FileNotFoundException {
		
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("|");
				Snack newSnack = new Snack(splitLine[1], new BigDecimal(splitLine[2]), splitLine[3], 5);
				snackMap.put(splitLine[0], newSnack);

			}
		}
		return snackMap;
	}
}