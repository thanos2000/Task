package com.example.Student.mang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.mang.Dto.StudentDto;
import com.example.Student.mang.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
		StudentDto student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto student) {
		StudentDto saveStudent = studentService.createStudent(student);
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDto student) {
		student.setId(id);
		StudentDto updatedStudent = studentService.updateStudent(id, student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		// return new ResponseEntity<>("Student deleted!", HttpStatus.OK);
	}

	/*
	 * @ExceptionHandler(ResourceNotFoundException.class) public
	 * ResponseEntity<ErrorDetails>
	 * resourceNotFoundException(ResourceNotFoundException exception, WebRequest
	 * webRequest) {
	 * 
	 * ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
	 * exception.getMessage(), webRequest.getDescription(false),
	 * "STUDENT_NOT_FOUND");
	 * 
	 * return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

}