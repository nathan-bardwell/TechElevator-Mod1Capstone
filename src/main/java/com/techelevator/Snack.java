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
	public int getSnackQuantity(){
		return snackQuantity;
	}
	public void decreaseSnackQuantity() {
		this.snackQuantity -= 1;
	}
	
	public void consumeSnack() {
		String consumeString = "";
		if (snackQuantity < 5) {
			if (snackType.equals("Chip")) {
				consumeString = "\nCrunch Crunch, Yum!";
			} else if (snackType.equals("Candy")) {
				consumeString = "\nMunch Munch, Yum!";
			} else if (snackType.equals("Drink")) {
				consumeString = "\nGlug Glug, Yum!";
			} else if (snackType.equals("Gum")) {
				consumeString = "\nChew Chew, Yum!";
			}
		}
		if (!consumeString.equals("")) {
			System.out.println(consumeString);
		}
	}
}
