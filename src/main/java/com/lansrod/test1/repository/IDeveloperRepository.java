package com.lansrod.test1.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lansrod.test1.entity.Developer;

@Repository
@Transactional
public interface IDeveloperRepository extends CrudRepository<Developer, Long> {

	@Query(value = "Select d From Developer as d where d.language != null and d.language.id = :languageId")
	public Iterable<Developer> findByLanguageId(Long languageId);

}
