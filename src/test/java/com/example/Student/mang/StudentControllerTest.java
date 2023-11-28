package com.example.Student.mang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Controller.StudentController;
import com.example.Student.mang.Dto.StudentDto;
import com.example.Student.mang.Mapper.StudentMapper;
import com.example.Student.mang.Service.StudentService;

class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    void testGetAllStudents() {
       
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(new StudentDto(), new StudentDto()));
        ResponseEntity<List<StudentDto>> responseEntity = studentController.getAllStudents();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
    }

	@Test
	void testGetStudentById() {

		Long studentId = 1L;
		when(studentService.getStudentById(studentId)).thenReturn(new StudentDto());
		ResponseEntity<StudentDto> responseEntity = studentController.getStudentById(studentId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(StudentDto.class, responseEntity.getBody().getClass());
	}

	@Test
	void testCreateStudent() {

		StudentDto studentDto = new StudentDto();
		when(studentService.createStudent(studentDto)).thenReturn(studentDto);
		ResponseEntity<StudentDto> responseEntity = studentController.createStudent(studentDto);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(studentDto, responseEntity.getBody());
	}

	@Test
	void testUpdateStudent() {

		Long studentId = 1L;
		StudentDto studentDto = new StudentDto();
		when(studentService.updateStudent(studentId, studentDto)).thenReturn(studentDto);

		ResponseEntity<StudentDto> responseEntity = studentController.updateStudent(studentId, studentDto);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(studentDto, responseEntity.getBody());
	}

	@Test
	void testDeleteStudent() {

		Long studentId = 1L;
		studentController.deleteStudent(studentId);
		verify(studentService, times(1)).deleteStudent(studentId);
	}

	@Test
	void testConstructorAndGettersSetters() {

		long id = 1L;
		String name = "John";
		int age = 25;
		double salary = 50000.0;

		Student student = new Student(id, name, age, salary);

		assertEquals(id, student.getId());
		assertEquals(name, student.getName());
		assertEquals(age, student.getAge());
		assertEquals(salary, student.getSalary());

		long newId = 2L;
		student.setId(newId);
		assertEquals(newId, student.getId());

		String newName = "Jane";
		student.setName(newName);
		assertEquals(newName, student.getName());

		int newAge = 30;
		student.setAge(newAge);
		assertEquals(newAge, student.getAge());
		double newSalary = 60000.0;
		student.setSalary(newSalary);
		assertEquals(newSalary, student.getSalary());
	}

	@Test
	void testMapToStudentDto() {

		Student student = new Student(1L, "John", 25, 50000.0);

		StudentDto studentDto = StudentMapper.mapToStudentDto(student);

		assertEquals(student.getId(), studentDto.getId());
		assertEquals(student.getName(), studentDto.getName());
		assertEquals(student.getAge(), studentDto.getAge());
		assertEquals(student.getSalary(), studentDto.getSalary());
	}

	@Test
	void testMapToStudent() {

		StudentDto studentDto = new StudentDto(1L, "John", 25, 50000.0);

		Student student = StudentMapper.mapToStudent(studentDto);

		assertEquals(studentDto.getId(), student.getId());
		assertEquals(studentDto.getName(), student.getName());
		assertEquals(studentDto.getAge(), student.getAge());
		assertEquals(studentDto.getSalary(), student.getSalary());
	}

}