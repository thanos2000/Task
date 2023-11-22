package com.example.Student.mang;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Long> {

	List<Student> findAll();

	Optional<Student> findById(String id);

	void deleteById(String id);

	Student save(Student student);

	boolean existsById(Long id);

}