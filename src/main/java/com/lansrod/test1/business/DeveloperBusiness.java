package com.lansrod.test1.business;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lansrod.test1.entity.Developer;
import com.lansrod.test1.entity.Language;
import com.lansrod.test1.entity.exception.DeveloperNotFoundException;
import com.lansrod.test1.entity.exception.LanguageNotFoundException;
import com.lansrod.test1.repository.IDeveloperRepository;

@Service
public class DeveloperBusiness implements IDeveloperBusiness {

	@Autowired
	private IDeveloperRepository developerRepository;

	@Autowired
	private ILanguageBusiness languageBusiness;

	@Autowired
	private Mapper mapper;

	public Developer create(Developer entity) {
		return developerRepository.save(entity);
	}

	public void update(Long id, Developer developer) throws DeveloperNotFoundException {
		Developer developerOld = this.findById(id);
		mapper.map(developer, developerOld, "developer-update");
		developerRepository.save(developerOld);
	}

	public Developer findById(Long id) throws DeveloperNotFoundException {
		Optional<Developer> developer = developerRepository.findById(id);
		if (!developer.isPresent()) {
			throw new DeveloperNotFoundException();
		}
		return developer.get();
	}

	public Iterable<Developer> findAll() {
		return developerRepository.findAll();
	}

	public void setLanguageToDeveloper(Long idDeveloper, Long idLanguage)
			throws DeveloperNotFoundException, LanguageNotFoundException {
		Developer developer = this.findById(idDeveloper);
		Language language = languageBusiness.findById(idLanguage);
		developer.setLanguage(language);
		this.update(developer.getId(), developer);
	}

}
