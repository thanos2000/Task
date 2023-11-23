package com.example.Student.mang.Service;

import java.util.List;

import com.example.Student.mang.Bean.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student createStudent(Student student);

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);

	void deleteStudent(String id);

	Student getStudentById(String id);
}