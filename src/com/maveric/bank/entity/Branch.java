package com.maveric.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Branch {

	public Branch() {

	}

	public Branch(String branchID, List<BankAccount> bankAccounts, List<Customer> customers) {
		super();
		this.branchID = branchID;
		this.bankAccounts = bankAccounts;
		this.customers = customers;
	}

	private String branchID;
	private List<BankAccount> bankAccounts;
	private List<Customer> customers;

	public BankAccount createBankAccount(String panNumber, String type, Double amount) {
		BankAccount ba = type.equals("Savings") ? new SavingAccount() : new CurrentAccount();
		ba.setCurrentBalance(amount);
		ba.setMinimumBalance(type.equals("Savings") ?   10000d : 20000d);
		ba.setAccountNumber(bankAccounts.isEmpty()  ? "1" : Integer.toString(bankAccounts.size() + 1));
		if(customers.isEmpty()) {
			Customer customer = new Customer(new ArrayList<BankAccount>());
			customer.setPanNumber(panNumber);
			customer.getBankAccounts().add(ba);
			this.customers.add(customer);
		}else {
			for (Customer c : customers) {
				if (c.getPanNumber().equals(panNumber)) {
					c.getBankAccounts().add(ba);
					break;
				} else {
					Customer customer = new Customer(new ArrayList<BankAccount>());
					customer.setPanNumber(panNumber);
					customer.getBankAccounts().add(ba);
					this.customers.add(customer);
					break;
				}
			}
		}
		this.bankAccounts.add(ba);
		return ba;
	}

	public Customer getCustomerByPan(String panNumber) {
		for (Customer custpan : customers) {
			if (custpan.getPanNumber().equals(panNumber)) {
				return custpan;
			} 
		}
		return null;
	}

	public BankAccount getAccountByAccountNumber(String accountNumber) {
		for (BankAccount ac : bankAccounts) {
			if (ac.getAccountNumber().equals(accountNumber)) {
				return ac;
			}
		}

		return null;

	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customeres) {
		this.customers = customeres;
	}

}
