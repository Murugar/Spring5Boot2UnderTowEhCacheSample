package com.iqmsoft.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iqmsoft.entity.Dept;
import com.iqmsoft.entity.Person;

@Repository
@Transactional
public class DeptRepository {

	@Autowired
	EntityManager entityManager;

	public Dept findById(Long id) {
		return entityManager.find(Dept.class, id);
	}

	public Dept save(Dept department) {
		if (department.getId() == null) {
			entityManager.persist(department);
		} else {
			entityManager.merge(department);
		}
		return department;
	}

	public void deleteById(Long id) {
		Dept department = findById(id);
		entityManager.remove(department);
	}
}
