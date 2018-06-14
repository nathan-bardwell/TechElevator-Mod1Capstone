package com.techelevator;

import java.math.BigDecimal;

public class Snack {
//Attributes
	private String snackType;
	private String snackName;
	private BigDecimal snackPrice;
	
//Constructor
	public Snack(String name, BigDecimal price, String type) {
		this.snackName = name;
		this.snackPrice = price;
		this.snackType = type;
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
