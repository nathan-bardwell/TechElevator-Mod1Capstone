package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VendingMachine {
//Attributes
	private boolean wasProductDispensed = false;
	private String productLocation;
	private BigDecimal totalMoneyInMachine;
	private Inventory machineInventory;
	private BigDecimal changeToGive;
	// constructor
	public VendingMachine() throws FileNotFoundException{
	totalMoneyInMachine = new BigDecimal("0.00");
	this.machineInventory = new Inventory();
	machineInventory.fillInventory();
	changeToGive = new BigDecimal("0.00");
}
	
//Methods
	public void printInventory() {
		String newString = null;
		Set<String> keys = machineInventory.snackMap.keySet();
		for (String location : keys) {
		    newString = location + "  ---->  " + machineInventory.snackMap.get(location).getSnackName() + "  $" + machineInventory.snackMap.get(location).getSnackPrice() + " Quantity Remaining: " + machineInventory.snackMap.get(location).getSnackQuantity();
		    System.out.println(newString);
		    	}
	}
	public void feedMoney(BigDecimal money) {
		this.totalMoneyInMachine = totalMoneyInMachine.add(money);
	}
	
	public void selectProduct(String userCode) {
		this.productLocation = userCode;
		Set<String> keys = machineInventory.snackMap.keySet();
		for (String productCode : keys) {
			if (productLocation.equals(productCode)) {
				dispenseProduct();
				wasProductDispensed = true;
			} 
		}
		if (wasProductDispensed) {
			System.out.println("Enjoy your snack.");
		} else {
			System.out.println("The code " + productLocation + " does not exist. Please enter a valid code.");

		}
		
	}
	
	public void giveChange(BigDecimal changeToGive) {
		
	}
	
	public void dispenseProduct() {
		machineInventory.snackMap.get(productLocation).decreaseSnackQuantity();
		
	}
	
	public void finishTransaction() {
		
	}
	
	public void createLog() {
		
	}
	public BigDecimal getTotalMoney(){
		return totalMoneyInMachine;
		
	}
	}
	

