package com.codingdojo.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Questions;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Long> {
	//find all questions
	List<Questions> findAll();
	
	Optional<Questions> findByQuestion(String string);
}
