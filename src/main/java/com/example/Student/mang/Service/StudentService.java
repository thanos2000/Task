package com.example.Student.mang.Service;

import java.util.List;

import com.example.Student.mang.Dto.StudentDto;

public interface StudentService {

	List<StudentDto> getAllStudents();

	StudentDto getStudentById(long id);

	StudentDto createStudent(StudentDto student);

	StudentDto updateStudent(long id, StudentDto student);

	void deleteStudent(long id);

}