package com.iqmsoft.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iqmsoft.entity.Person;

@Repository
@Transactional
public class PersonRepository {

	@Autowired
	EntityManager entityManager;

	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}

	public Person save(Person laborer) {
		if (laborer.getId() == null) {
			entityManager.persist(laborer);
		} else {
			entityManager.merge(laborer);
		}
		return laborer;
	}

	public void deleteById(Long id) {
		Person laborer = findById(id);
		entityManager.remove(laborer);
	}
	
}
