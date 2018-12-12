package com.lansrod.test1.controller;

import java.net.BindException;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.lansrod.test1.entity.exception.DeveloperNotFoundException;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;
import com.lansrod.test1.ws.AbstractResponse;
import com.lansrod.test1.ws.FailResponse;
import com.lansrod.test1.ws.ValidationFailResponse;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({ DeveloperNotFoundException.class })
	public ResponseEntity<AbstractResponse> developerNotFoundException(Locale locale,
			DeveloperNotFoundException developerNotFoundException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new FailResponse(404L, developerNotFoundException.getMessage()));
	}

	@ExceptionHandler({ LanguageNotFoundException.class })
	public ResponseEntity<AbstractResponse> languageNotFoundException(Locale locale,
			LanguageNotFoundException languageNotFoundException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new FailResponse(404L, languageNotFoundException.getMessage()));
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<AbstractResponse> dethodArgumentTypeMismatchException(Locale locale,
			MethodArgumentTypeMismatchException dethodArgumentTypeMismatchException) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new FailResponse(400L, dethodArgumentTypeMismatchException.getMessage()));
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<AbstractResponse> methodArgumentNotValidException(Locale locale,
			MethodArgumentNotValidException methodArgumentNotValidException) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ValidationFailResponse(methodArgumentNotValidException.getBindingResult()));
	}

	@ExceptionHandler({ BindException.class })
	public ResponseEntity<AbstractResponse> bindException(Locale locale, BindException bindException) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponse(400L, bindException.getMessage()));
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<AbstractResponse> exception(Locale locale, Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new FailResponse(500L, exception.getMessage()));
	}

}
