package com.maveric.bank;

import java.util.List;

import com.maveric.bank.entity.BankAccount;
import com.maveric.bank.entity.Branch;
import com.maveric.bank.entity.CurrentAccount;
import com.maveric.bank.entity.HeadOffice;
import com.maveric.bank.entity.SavingAccount;
import com.maveric.bank.entity.Transaction;
import com.maveric.bank.exceptions.InsufficientBalanceException;
import com.maveric.bank.exceptions.InvalidAmountValueException;

public class BankClient {

	public static void main(String[] args) {
		HeadOffice office = new HeadOffice();

		System.out.println("Chennai Branch creation, adding accounts and performing transactions - starts");

		// Chennai Branch creation, adding accounts and performing transactions - starts

		Branch chennaiBranch = office.createBranch();
		SavingAccount savingsAcc1 = (SavingAccount) chennaiBranch.createBankAccount("DPUPS0875G", "Savings", 25000d);
		CurrentAccount currentAcc1 = (CurrentAccount) chennaiBranch.createBankAccount("DPUPS0875G", "Current", 30000d);
		SavingAccount savingsAcc2 = (SavingAccount) chennaiBranch.createBankAccount("DPUPS0875U", "Savings", 25000d);
		CurrentAccount currentAcc2 = (CurrentAccount) chennaiBranch.createBankAccount("DPUPS0875K", "Current", 30000d);

		System.out.println(savingsAcc1.deposit(2000d));
		try {
			savingsAcc1.deposit(-200d); // Exception case
		} catch (InvalidAmountValueException e) {
			e.printStackTrace();
		}
		System.out.println(savingsAcc1.withdraw(1000d));
		try {
			savingsAcc1.withdraw(10000000d); // Exception case
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}

		System.out.println(savingsAcc1.withdraw(100d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));

		List<Transaction> txnHistory = savingsAcc1.getTransactionHistory();
		for (Transaction t : txnHistory) {
			System.out.println("Txn.ID : " + t.getTransactionId() + " Txn.TYPE : " + t.getType() + " Txn.AMOUNT : "
					+ t.getAmount());
		}

		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));
		System.out.println(savingsAcc1.deposit(2000d));

		List<Transaction> miniStatementList = savingsAcc1.getMiniStatement();
		System.out.println("miniStatement history for last 10 transactions for Account: " );
		for (Transaction t : miniStatementList) {
			System.out.println("Txn.ID : " + t.getTransactionId() + " Txn.TYPE : " + t.getType() + " Txn.AMOUNT : "
					+ t.getAmount());
		}

		System.out.println("Chennai Branch creation, adding accounts and performing transactions - ends");
		
		System.out.println("------------------------------------------------------------------");
		// Chennai Branch creation, adding accounts and performing transactions - ends

		System.out.println("Pune Branch creation, adding accounts and performing transactions - starts");

		// Pune Branch creation, adding accounts and performing transactions - starts

		Branch puneBranch = office.createBranch();
		SavingAccount punesavingsAcc1 = (SavingAccount) puneBranch.createBankAccount("DPUPS0875G", "Savings", 25000d);
		CurrentAccount punecurrentAcc1 = (CurrentAccount) puneBranch.createBankAccount("DPUPS0875G", "Current", 30000d);
		SavingAccount punesavingsAcc2 = (SavingAccount) puneBranch.createBankAccount("DPUPS0875U", "Savings", 25000d);
		CurrentAccount punecurrentAcc2 = (CurrentAccount) puneBranch.createBankAccount("DPUPS0875K", "Current", 30000d);

		System.out.println(punesavingsAcc1.deposit(2000d));
		try {
			punesavingsAcc1.deposit(-200d); // Exception case
		} catch (InvalidAmountValueException e) {
			e.printStackTrace();
		}
		System.out.println(punesavingsAcc1.withdraw(1000d));
		try {
			punesavingsAcc1.withdraw(10000000d); // Exception case
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}

		System.out.println(punesavingsAcc1.withdraw(100d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));

		List<Transaction> txnHistory2 = punesavingsAcc1.getTransactionHistory();
		for (Transaction t : txnHistory2) {
			System.out.println("Txn.ID : " + t.getTransactionId() + " Txn.TYPE : " + t.getType() + " Txn.AMOUNT : "
					+ t.getAmount());
		}

		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));
		System.out.println(punesavingsAcc1.deposit(2000d));

		List<Transaction> miniStatementList2 = punesavingsAcc1.getMiniStatement();
		System.out.println("miniStatement history for last 10 transactions");
		for (Transaction t : miniStatementList2) {
			System.out.println("Txn.ID : " + t.getTransactionId() + " Txn.TYPE : " + t.getType() + " Txn.AMOUNT : "
					+ t.getAmount());
		}

		System.out.println("Pune Branch creation, adding accounts and performing transactions - ends");
		// Pune Branch creation, adding accounts and performing transactions - ends
	}

}
