package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Answers;

@Repository
public interface AnswerRepository extends CrudRepository<Answers, Long> {
	//find all answers
	List<Answers> findAll();
}
