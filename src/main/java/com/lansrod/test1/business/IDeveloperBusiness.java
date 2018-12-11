package com.lansrod.test1.business;

import com.lansrod.test1.entity.Developer;
import com.lansrod.test1.entity.exception.DeveloperNotFoundException;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;

public interface IDeveloperBusiness {

	public Developer create(Developer entity);

	public void update(Long id, Developer developer) throws DeveloperNotFoundException;

	public Developer findById(Long id) throws DeveloperNotFoundException;

	public Iterable<Developer> findAll();

	public void setLanguageToDeveloper(Long idDeveloper, Long idLanguage)
			throws DeveloperNotFoundException, LanguageNotFoundException;

}
