package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	//find all the students
	List<Student> findAll();
	
	//delete dorm
	void deleteById(Long id);
	
	//find if student is added to a dorm or not
	List<Student> findByDormIsNull();
}
