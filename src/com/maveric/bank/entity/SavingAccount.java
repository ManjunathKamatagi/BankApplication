package com.maveric.bank.entity;

public class SavingAccount extends BankAccount {

	double minimumBalance = 10000;
	double interestRate = 4.5;
	
	@Override
	String getType() {
		return "Savings";
	}

}
