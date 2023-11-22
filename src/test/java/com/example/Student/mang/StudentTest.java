package com.example.Student.mang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentTest

{

	@Test

	void testSetAndGetters() {
		Student student = new Student();
		student.setName("John Doe");
		student.setAge(20);
		student.setSalary(50000.00);

		assertEquals("John Doe", student.getName());
		assertEquals(20, student.getAge());
		assertEquals(50000.00, student.getSalary());
	}
}