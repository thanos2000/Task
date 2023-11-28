package com.example.Student.mang;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Dto.StudentDto;
import com.example.Student.mang.Exception.ResourceNotFoundException;
import com.example.Student.mang.Repository.StudentRepository;
import com.example.Student.mang.ServiceImpl.StudentServiceImpl;

class StudentServiceImplTest {

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentServiceImpl studentService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    void testGetAllStudents() {
    
        when(studentRepository.findAll()).thenReturn(Collections.singletonList(new Student()));

        studentService.getAllStudents();
        verify(studentRepository, times(1)).findAll();
    }

	@Test
	void testGetStudentById() {

		long studentId = 1L;
		when(studentRepository.findById(studentId)).thenReturn(Optional.of(new Student()));
		studentService.getStudentById(studentId);
		verify(studentRepository, times(1)).findById(studentId);
	}

	@Test
	void testGetStudentByIdNotFound() {

		long nonExistentId = 999L;
		when(studentRepository.findById(nonExistentId)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> studentService.getStudentById(nonExistentId));
	}

	@Test
	void testCreateStudent() {

		StudentDto studentDto = new StudentDto();

		studentService.createStudent(studentDto);

		verify(studentRepository, times(1)).save(any(Student.class));
	}

	@Test
	void testUpdateStudent() {

		long studentId = 1L;
		StudentDto studentDto = new StudentDto();
		Student existingStudent = new Student();

		when(studentRepository.findById(studentId)).thenReturn(Optional.of(existingStudent));
		when(studentRepository.save(any(Student.class))).thenReturn(existingStudent);

		studentService.updateStudent(studentId, studentDto);
		verify(studentRepository, times(1)).findById(studentId);
		verify(studentRepository, times(1)).save(any(Student.class));
	}

	@Test
	void testUpdateStudentNotFound() {

		long nonExistentId = 999L;
		StudentDto studentDto = new StudentDto();

		when(studentRepository.findById(nonExistentId)).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> studentService.updateStudent(nonExistentId, studentDto));
	}

	@Test
	void testDeleteStudent() {

		long studentId = 1L;
		when(studentRepository.findById(studentId)).thenReturn(Optional.of(new Student()));
		studentService.deleteStudent(studentId);
		verify(studentRepository, times(1)).findById(studentId);
		verify(studentRepository, times(1)).deleteById(studentId);
	}

	@Test
	void testDeleteStudentNotFound() {

		long nonExistentId = 999L;
		when(studentRepository.findById(nonExistentId)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> studentService.deleteStudent(nonExistentId));
	}
}