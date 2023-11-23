package com.example.Student.mang.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.mang.Bean.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

	List<Student> findAll();

	Optional<Student> findById(String id);

	void deleteById(String id);

	Student save(Student student);

	boolean existsById(Long id);

}