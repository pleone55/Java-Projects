package com.codingdojo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.repositories.ContactRepository;
import com.codingdojo.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	//dependency injection
	private final StudentRepository studentRepository;
	private final ContactRepository contactRepository;
	
	public StudentService(StudentRepository studentRepository, ContactRepository contactRepository) {
		this.studentRepository = studentRepository;
		this.contactRepository = contactRepository;
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> findByDormIsNull(){
		return studentRepository.findByDormIsNull();
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}else {
			return null;
		}
	}
	
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	
	public Contact createContact(Contact c) {
		return contactRepository.save(c);
	}
}
