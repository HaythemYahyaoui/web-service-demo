package com.lansrod.test1.business;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lansrod.test1.entity.Language;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;
import com.lansrod.test1.repository.ILanguageRepository;

@Service
public class LanguageBusiness implements ILanguageBusiness {

	@Autowired
	private ILanguageRepository languageRepository;

	@Autowired
	private Mapper mapper;

	public Language create(Language entity) {
		return languageRepository.save(entity);
	}

	public void update(Long id, Language language) throws LanguageNotFoundException {
		Language languageOld = this.findById(id);
		mapper.map(language, languageOld, "language-update");
		languageRepository.save(languageOld);
	}

	public void delete(Language entity) {
		languageRepository.delete(entity);
	}

	public Language findById(Long id) throws LanguageNotFoundException {
		Optional<Language> language = languageRepository.findById(id);
		if (!language.isPresent()) {
			throw new LanguageNotFoundException();
		}
		return language.get();
	}

	public Iterable<Language> findAll() {
		return languageRepository.findAll();
	}

}
