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

import com.lansrod.test1.business.IDeveloperBusiness;
import com.lansrod.test1.entity.Developer;
import com.lansrod.test1.entity.exception.DeveloperNotFoundException;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;
import com.lansrod.test1.entity.validation.CreateDeveloperValidation;
import com.lansrod.test1.entity.validation.UpdateDeveloperValidation;
import com.lansrod.test1.ws.AbstractResponse;
import com.lansrod.test1.ws.SuccessResponse;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private IDeveloperBusiness developerBusiness;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> create(
			@Validated(value = { CreateDeveloperValidation.class }) @RequestBody Developer developer) {
		developer = developerBusiness.create(developer);
		URI location = UriComponentsBuilder.fromPath("/developers/{id}").buildAndExpand(developer.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(location).build();
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> update(@PathVariable("id") Long id,
			@Validated(UpdateDeveloperValidation.class) @RequestBody Developer developer)
			throws DeveloperNotFoundException {
		developerBusiness.update(id, developer);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> findById(@PathVariable("id") Long id) throws DeveloperNotFoundException {
		Developer developer = developerBusiness.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(developer));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(developerBusiness.findAll()));
	}

	@PutMapping(path = "/{idDeveloper}/language/{idLanguage}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AbstractResponse> setLanguageToDeveloper(@PathVariable("idDeveloper") Long idDeveloper,
			@PathVariable("idLanguage") Long idLanguage) throws DeveloperNotFoundException, LanguageNotFoundException {
		developerBusiness.setLanguageToDeveloper(idDeveloper, idLanguage);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
