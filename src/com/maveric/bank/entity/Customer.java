package com.maveric.bank.entity;

import java.util.List;

public class Customer {
	List<BankAccount> bankAccounts;
	String panNumber;
	
	public Customer(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
}
