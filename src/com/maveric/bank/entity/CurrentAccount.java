package com.maveric.bank.entity;

public class CurrentAccount extends BankAccount{

	double minimumBalance = 20000;
	double interestRate = 0;
	
	@Override
	String getType() {
		return "Current";
	}

}
