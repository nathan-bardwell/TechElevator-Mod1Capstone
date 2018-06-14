package com.techelevator;

import java.math.BigDecimal;

public class Snack {
//Attributes
	private String snackType;
	private String snackName;
	private BigDecimal snackPrice;
	private int snackQuantity;
	
//Constructor
	public Snack(String name, BigDecimal price, String type, int quantity) {
		this.snackName = name;
		this.snackPrice = price;
		this.snackType = type;
		this.snackQuantity = quantity;
	}
	
//Methods	
	public String getSnackType() {
		return snackType;
	}

	public String getSnackName() {
		return snackName;
	}
	
	public BigDecimal getSnackPrice() {
		return snackPrice;
	}
	
}
