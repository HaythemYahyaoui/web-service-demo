package com.lansrod.test1.ws;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FailResponse extends AbstractResponse {

	private static final long serialVersionUID = 8693802945900291448L;

	protected Map<String, String> errors;

	public FailResponse() {
		super(500L);
		errors = new HashMap<>();
	}

	public FailResponse(Serializable message) {
		super(500L, message);
		errors = new HashMap<>();
	}

	public FailResponse(Long status) {
		super(status);
		errors = new HashMap<>();
	}

	public FailResponse(Long status, Serializable message) {
		super(status, message);
		errors = new HashMap<>();
	}	
	
	public FailResponse(String error) {
		super(500L, null);
		this.errors = new HashMap<>();
		errors.put("error", error);
	}
	
	public FailResponse(Long status, String error) {
		super(status, null);
		this.errors = new HashMap<>();
		errors.put("error", error);
	}

	public FailResponse(Map<String, String> errors) {
		super(500L, null);
		this.errors = errors;
	}

	public FailResponse(Long status, Serializable message, Map<String, String> errors) {
		super(status, message);
		this.errors = errors;
	}

	public FailResponse(Long status, Map<String, String> errors) {
		super(status);
		this.errors = errors;
	}

	public FailResponse(Serializable message, Map<String, String> errors) {
		super(500L, message);
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

}
