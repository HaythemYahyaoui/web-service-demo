package com.lansrod.test1.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lansrod.test1.business.ILanguageBusiness;
import com.lansrod.test1.entity.Language;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;
import com.lansrod.test1.entity.validation.CreateLanguageValidation;
import com.lansrod.test1.entity.validation.UpdateLanguageValidation;
import com.lansrod.test1.ws.AbstractResponse;
import com.lansrod.test1.ws.SuccessResponse;

@RestController
@RequestMapping("/languages")
public class LanguageController {

	@Autowired
	private ILanguageBusiness languageBusiness;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> create(
			@Validated(CreateLanguageValidation.class) @RequestBody Language language) {
		language = languageBusiness.create(language);
		URI location = UriComponentsBuilder.fromPath("/languages/{id}").buildAndExpand(language.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(location).build();
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> update(
			@Validated(UpdateLanguageValidation.class) @PathVariable("id") Long id, @RequestBody Language language)
			throws LanguageNotFoundException {
		languageBusiness.update(id, language);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> findById(@PathVariable("id") Long id) throws LanguageNotFoundException {
		Language language = languageBusiness.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(language));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(languageBusiness.findAll()));
	}

}
