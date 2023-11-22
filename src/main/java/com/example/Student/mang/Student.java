package com.example.Student.mang;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
@Document
public class Student {
	
	private Long id;
	private String name;
	private int age;
	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setid(Long id2) {

	}
}