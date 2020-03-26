package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	//find all contacts
	List<Contact> findAll();
}