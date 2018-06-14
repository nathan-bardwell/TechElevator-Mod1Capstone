package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

	TreeMap<String, Snack> snackMap = new TreeMap<String, Snack>();

	public Inventory()  {

	}

	
	
	public TreeMap<String, Snack> fillInventory() throws  FileNotFoundException {
		File inventoryFile = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("\\|");
				Snack newSnack = new Snack(splitLine[1], new BigDecimal(splitLine[2]), splitLine[3], 5);
				snackMap.put(splitLine[0], newSnack);

			}
		}
		return snackMap;
	}
}