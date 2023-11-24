package com.example.Student.mang.Mapper;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Dto.StudentDto;

public class StudentMapper {

	public static StudentDto mapToStudentDto(Student savedStudent) {
		StudentDto studentDto = new StudentDto(savedStudent.getId(), savedStudent.getName(), savedStudent.getAge(),
				savedStudent.getSalary());
		return studentDto;
	}

	public static Student mapToStudent(StudentDto studentDto) {
		Student student = new Student(studentDto.getId(), studentDto.getName(), studentDto.getAge(),
				studentDto.getSalary());
		return student;
	}

	public static StudentDto mapToStudentDto(StudentDto student) {
		return null;
	}
}
