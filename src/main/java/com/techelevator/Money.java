package com.techelevator;

import java.math.BigDecimal;

public class Money {
	BigDecimal value;
	String name;

	public Money(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}



