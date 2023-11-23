package com.example.Student.mang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Student.mang.Bean.Student;

class StudentTest

{

	@Test

	void testSetAndGetters() {
		Student student = new Student();
		student.setName("Gautham");
		student.setAge(23);
		student.setSalary(50000.00);

		assertEquals("Gautham", student.getName());
		assertEquals(23, student.getAge());
		assertEquals(50000.00, student.getSalary());
	}
}