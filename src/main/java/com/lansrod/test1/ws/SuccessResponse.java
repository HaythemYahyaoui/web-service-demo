package com.lansrod.test1.ws;

import java.io.Serializable;

public class SuccessResponse extends AbstractResponse {

	private static final long serialVersionUID = 8693802945900291448L;

	public SuccessResponse() {
		super(200L);
	}

	public SuccessResponse(Object message) {
		super(200L, message);
	}

	public SuccessResponse(Long status) {
		super(status);
	}

	public SuccessResponse(Long status, Serializable message) {
		super(status, message);
	}

}
