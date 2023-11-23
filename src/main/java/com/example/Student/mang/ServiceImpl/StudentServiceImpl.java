package com.example.Student.mang.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Repository.StudentRepository;
import com.example.Student.mang.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	// Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(String id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		return optionalStudent.orElse(null);
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		if (studentRepository.existsById(id)) {
			student.setId(id);
			return studentRepository.save(student);
		}
		return null;
	}

	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(Long id) {
		return null;
	}

	@Override
	public void deleteStudent(Long id) {

	}
}
