package com.lansrod.test1.ws;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.validation.BindingResult;

public class ValidationFailResponse extends FailResponse {

	private static final long serialVersionUID = 1657987453504654586L;

	public ValidationFailResponse() {
		super(400L);
	}

	public ValidationFailResponse(Set<ConstraintViolation<?>> constraintViolations) {
		errors = constraintViolations.stream().collect(HashMap<String, String>::new, (a, b) -> {
			a.put(b.getPropertyPath().toString(), b.getMessage());
		}, Map::putAll);
	}

	public ValidationFailResponse(BindingResult bindingResult) {
		errors = bindingResult.getFieldErrors().stream().collect(HashMap<String, String>::new, (a, b) -> {
			a.put(b.getField(), b.getDefaultMessage());
		}, Map::putAll);
	}

}
