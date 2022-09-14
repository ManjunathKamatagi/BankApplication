package com.maveric.bank.entity;

import java.util.ArrayList;
import java.util.List;

import com.maveric.bank.exceptions.InsufficientBalanceException;
import com.maveric.bank.exceptions.InvalidAmountValueException;

public abstract class BankAccount {
	String accountNumber;
	Double minimumBalance;
	Double currentBalance;
	Double interestRate;
	List<Transaction> transactions;

	abstract String getType();
	
	public BankAccount() {
		this.transactions = new ArrayList<>();
	}
	
	
	public String withdraw(double amount) {
		if(currentBalance - amount< minimumBalance) {
			throw new InsufficientBalanceException();
		}else {
			this.currentBalance = currentBalance - amount;
			transactions.add(getTransaction("Withdraw", amount));
			return "Amount withdrawn successfully";
		}
	}
	
	public String deposit(double amount) {
		if(amount < 0) {
			throw new InvalidAmountValueException();
		}else {
			this.currentBalance = currentBalance + amount;
			transactions.add(getTransaction("Deposit",amount));
			return "amount deposited successfully";
		}
	}
	
	public List<Transaction> getTransactionHistory(){
		return this.transactions;
	}
	
	public List<Transaction> getMiniStatement(){
		if(transactions.size()>10) {
			List<Transaction> miniStatement = new ArrayList<>();
			for(int i= transactions.size()-10;i<transactions.size();i++) {
				miniStatement.add(transactions.get(i));
			}
			return miniStatement;
		}else {
			return transactions;
		}
	}
	
	
	
	public Transaction getTransaction(String type,double amount) {
		Transaction t = new Transaction();
		t.setAmount(amount);
		t.setType(type);
		t.setTransactionId(transactions == null? "1": Integer.toString(transactions.size()+1));
		return t;
		
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}


