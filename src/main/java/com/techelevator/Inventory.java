package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Inventory {

	HashMap<String, ArrayList<String>> snackMap = new HashMap<String, ArrayList<String>>();
	ArrayList<String> snackList = new ArrayList<String>();

	public Inventory() throws FileNotFoundException {

	}

	File inventoryFile = new File("vendingmachine.csv");
	{
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] splitLine = line.split("|");
			snackList.add(splitLine[1]);
			
		}
		}
	}
}