package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VendingMachine {
	// Attributes
	private boolean productExists = false;
	private String productLocation;
	private String productInfo;
	private BigDecimal totalMoneyInMachine;
	private Inventory machineInventory;
	private File auditFile;
	private PrintWriter auditWriter;

	// constructor
	public VendingMachine() throws FileNotFoundException {
		auditFile = new File("log.txt");
		auditWriter = new PrintWriter(auditFile);
		totalMoneyInMachine = new BigDecimal("0.00");
		this.machineInventory = new Inventory();
		machineInventory.fillInventory();
	}

	// Methods
	public void printInventory() {
		String newString = null;
		Set<String> keys = machineInventory.snackMap.keySet();
		for (String location : keys) {
			newString = location + "  ---->  " + machineInventory.snackMap.get(location).getSnackName() + "  $"
					+ machineInventory.snackMap.get(location).getSnackPrice() + " Quantity Remaining: "
					+ machineInventory.snackMap.get(location).getSnackQuantity();
			System.out.println(newString);
		}
	}

	public void feedMoney(BigDecimal money) {
		this.totalMoneyInMachine = totalMoneyInMachine.add(money);
	}

	public boolean selectProduct(String userCode) {
		this.productLocation = userCode;
		Set<String> keys = machineInventory.snackMap.keySet();
		for (String productCode : keys) {

			if (productLocation.equals(productCode)) {
				productExists = true;
			}
		}
		if (productExists) {
			if (machineInventory.snackMap.get(productLocation).getSnackQuantity() == 0) {
				System.out.println("\nThis item is SOLD OUT");
			} else {
				dispenseProduct();

			}
			return true;
		} else {
			System.out.println("\nThe code " + productLocation + " does not exist. Please enter a valid code.");
			return false;
		}

	}

	public void dispenseProduct() {
		if (totalMoneyInMachine.compareTo(machineInventory.snackMap.get(productLocation).getSnackPrice()) == 0
				|| totalMoneyInMachine.compareTo(machineInventory.snackMap.get(productLocation).getSnackPrice()) == 1) {
			machineInventory.snackMap.get(productLocation).decreaseSnackQuantity();
			totalMoneyInMachine = totalMoneyInMachine
					.subtract(machineInventory.snackMap.get(productLocation).getSnackPrice());
		} else {
			System.out.println(
					"\n\n\nYOU DO NOT HAVE ENOUGH MONEY FOR THIS ITEM.\nCHOOSE ANOTHER PRODUCT OR INSERT MORE MONEY\n\n\n");
		}

	}

	public void finishTransaction() {
		giveChange();
		Set<String> keys = machineInventory.snackMap.keySet();
		for (String productCode : keys) {
			machineInventory.snackMap.get(productCode).consumeSnack();
		}
	}

	public void giveChange() {
		System.out.println("\nPlease take your change: $" + totalMoneyInMachine);
		double totalMoneyDouble = Double.parseDouble(totalMoneyInMachine.toString());

		int quarters = 0;
		int dimes = 0;
		int nickels = 0;

		if (totalMoneyDouble > 0.00) {
			quarters += totalMoneyDouble / 0.25;
			totalMoneyDouble = totalMoneyDouble % 0.25;
		} else {
			System.out.println("No change left to give");
		}
		if (totalMoneyDouble > 0.00) {
			dimes += totalMoneyDouble / 0.10;
			totalMoneyDouble = totalMoneyDouble % 0.10;
		} else {
			System.out.println("No change left to give");
			return;
		}
		if (totalMoneyDouble > 0.00) {
			nickels += totalMoneyDouble / 0.05;
		} else {
			System.out.println("No change left to give");
			return;
		}

		System.out.println("[" + quarters + " quarters]");
		System.out.println("[" + dimes + " dimes]");
		System.out.println("[" + nickels + " nickels]");
		totalMoneyInMachine = new BigDecimal("0.00");
	}

	public Snack getProductInfo() {
		return machineInventory.snackMap.get(productLocation);
	}

	public void writeToLog(String transactionInfo) throws FileNotFoundException {

		try {
			auditWriter.println(transactionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeWriter() {
		auditWriter.close();
	}

	public BigDecimal getTotalMoney() {
		return totalMoneyInMachine;

	}
}
