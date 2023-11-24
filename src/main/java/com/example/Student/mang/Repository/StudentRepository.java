package com.example.Student.mang.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.mang.Bean.Student;
import com.example.Student.mang.Dto.StudentDto;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

	//List<Student> findAll();

	//Optional<Student> findById(long id);

	//void deleteById(long id);

	//Student save(StudentDto student);

	boolean existsById(long id);

}