package com.lansrod.test1.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lansrod.test1.entity.Language;

@Repository
@Transactional
public interface ILanguageRepository extends CrudRepository<Language, Long> {

}
