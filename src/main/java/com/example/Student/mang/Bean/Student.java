package com.example.Student.mang.Bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
	@org.springframework.data.annotation.Id
	private long id;
	private String name;
	private int age;
	private double salary;

	public Student() {
		super();
	}

	public Student(long id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

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

	public void setId1(long id2) {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
