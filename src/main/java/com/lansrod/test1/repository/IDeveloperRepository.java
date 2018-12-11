package com.lansrod.test1.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lansrod.test1.entity.Developer;

@Repository
@Transactional
public interface IDeveloperRepository extends CrudRepository<Developer, Long> {

	public Developer findByEmailAndPassword(String email, String password);
	
}
