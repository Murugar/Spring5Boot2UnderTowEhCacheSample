package com.iqmsoft;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.entity.Dept;
import com.iqmsoft.entity.Person;
import com.iqmsoft.entity.Manager;
import com.iqmsoft.repository.DeptRepository;
import com.iqmsoft.repository.PersonRepository;
import com.iqmsoft.repository.ManagerRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	PersonRepository laborerRepository;

	@Autowired
	DeptRepository departmentRepository;


	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Dept dep1 = new Dept("Software");
		Dept dep2 = new Dept("Marketing");

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("Emre", "Eker", BigDecimal.valueOf(3000), dep1)));

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("Cemre", "Eker", BigDecimal.valueOf(4000), dep2)));

		logger.info("Added  Laborer ->{}",
				laborerRepository.save(new Person("John", "Smit", BigDecimal.valueOf(2000), 2, dep1)));
		logger.info("Added  Laborer ->{}",
				laborerRepository.save(new Person("Michael", "Carlson", BigDecimal.valueOf(3000), 3, dep1)));

		managerRepository.deleteById(Long.valueOf(1));

		logger.info("Added  Manageer ->{}",
				managerRepository.save(new Manager("İsmail", "Eker", BigDecimal.valueOf(3000), dep1)));

		dep1.setDept_name("Computer Hardware");
		
		laborerRepository.deleteById(Long.valueOf(5));

		managerRepository.deleteById(Long.valueOf(7));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(4)));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(2)));
		logger.info("Get from cache ->{}",departmentRepository.findById(Long.valueOf(4)));

	}
}
