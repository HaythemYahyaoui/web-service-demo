package com.lansrod.test1.entity.exception;

public class DeveloperNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2835349257090817964L;

	public DeveloperNotFoundException() {
		super("User not found");
		// TODO Auto-generated constructor stub
	}

	public DeveloperNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DeveloperNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeveloperNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeveloperNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
