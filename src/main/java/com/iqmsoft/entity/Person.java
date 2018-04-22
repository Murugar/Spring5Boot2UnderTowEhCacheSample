package com.iqmsoft.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Person extends Employee{
	
	private BigDecimal salary;
	private int level;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	Dept department;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Person() {
	}

	public Person(String name,String surname, BigDecimal salary,int level, Dept dep1) {
		super(name,surname);
		this.salary = salary;
		this.level=level;
		this.department=dep1;
	}

}
