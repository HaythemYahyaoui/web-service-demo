package com.lansrod.test1.business;

import com.lansrod.test1.entity.Language;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;

public interface ILanguageBusiness {

	public Language create(Language entity);

	public void update(Long id, Language language) throws LanguageNotFoundException;

	public void delete(Language entity);

	public Language findById(Long id) throws LanguageNotFoundException;

	public Iterable<Language> findAll();
}
