package com.maveric.bank.exceptions;

public class InvalidAmountValueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAmountValueException() {
		super("Invalid amount entered for deposit");
	}
}
