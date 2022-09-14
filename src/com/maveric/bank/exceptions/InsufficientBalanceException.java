package com.maveric.bank.exceptions;

public class InsufficientBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
		super("Insufficient balance in the account");
	}
}
