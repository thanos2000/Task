package com.example.Student.mang.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Dto.StudentDto;
import com.example.Student.mang.Exception.ResourceNotFoundException;
import com.example.Student.mang.Mapper.StudentMapper;
import com.example.Student.mang.Repository.StudentRepository;
import com.example.Student.mang.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	// Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students.stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
	}

	@Override
	public StudentDto getStudentById(long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		// Student student = optionalStudent.orElse(null);
		return StudentMapper.mapToStudentDto(student);
	}

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student = StudentMapper.mapToStudent(studentDto);

		Student savedStudent = studentRepository.save(student);
		StudentDto savedStudentDto = StudentMapper.mapToStudentDto(savedStudent);
		return savedStudentDto;
	}

	@Override
	public StudentDto updateStudent(long id, StudentDto student) {

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", student.getId()));
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setSalary(student.getSalary());
		Student updatedStudent = studentRepository.save(existingStudent);

		/*if (studentRepository.existsById(id)) {
			student.setId(id);
			Student updatedStudent = studentRepository.save(null);
		}*/
		return StudentMapper.mapToStudentDto(updatedStudent);
	}

	@Override
	public void deleteStudent(long id) {

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		studentRepository.deleteById(id);
	}

}
