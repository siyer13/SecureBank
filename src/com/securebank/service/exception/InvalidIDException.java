package com.securebank.cxfrestservice.exception;

public class InvalidIDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752209120419462792L;


	public InvalidIDException() {
		super();
	}
	
	public InvalidIDException(String message) {
		super(message);
	}
	
	public InvalidIDException(Throwable cause) {
		super(cause);
	}
	
	public InvalidIDException(String message, Throwable cause) {
		super(message,cause);
	}
}
