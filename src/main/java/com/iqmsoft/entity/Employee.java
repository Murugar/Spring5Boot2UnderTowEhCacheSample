package com.iqmsoft.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String surname;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	protected Employee() {}

	protected Employee(String name,String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
