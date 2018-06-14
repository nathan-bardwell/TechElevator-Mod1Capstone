package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class VendingMachine {
//Attributes
	private Snack product;
	private String productLocation;
	private BigDecimal totalMoneyInMachine;
	private Inventory machineInventory;
	private BigDecimal changeToGive;
	// constructor
	public VendingMachine() throws FileNotFoundException{
	this.machineInventory = new Inventory();
	machineInventory.fillInventory();
}
	
//Methods
	public void feedMoney(BigDecimal money) {
		
	}
	
	public void giveChange(BigDecimal changeToGive) {
		
	}
	
	public void selectProduct(String location) {
		
	}
	
	public void dispenseProduct() {
		
	}
	
	public void finishTransaction() {
		
	}
	
	public void createLog() {
		
	}
	
}
