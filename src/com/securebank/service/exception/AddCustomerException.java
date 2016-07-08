package com.securebank.service.exception;

public class AddCustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752209120419462792L;


	public AddCustomerException() {
		super();
	}
	
	public AddCustomerException(String message) {
		super(message);
	}
	
	public AddCustomerException(Throwable cause) {
		super(cause);
	}
	
	public AddCustomerException(String message, Throwable cause) {
		super(message,cause);
	}
}
