package com.iqmsoft.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.entity.Manager;

@Repository
@Transactional
public class ManagerRepository {

	@Autowired
	EntityManager entityManager;

	public Manager findById(Long id) {
		return entityManager.find(Manager.class, id);
	}

	public Manager save(Manager manager) {
		if (manager.getId() == null) {
			entityManager.persist(manager);
		} else {
			entityManager.merge(manager);
		}
		return manager;
	}

	public void deleteById(Long id) {
		Manager manager = findById(id);
		entityManager.remove(manager);
	}

}
