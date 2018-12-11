package com.lansrod.test1.entity.exception;

public class LanguageNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2835349257090817964L;

	public LanguageNotFoundException() {
		super("User not found");
		// TODO Auto-generated constructor stub
	}

	public LanguageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LanguageNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LanguageNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LanguageNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
