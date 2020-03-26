package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Questions;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	//dependency injection
	private final QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	//return all questions
	public List<Questions> allQuestions(){
		return questionRepo.findAll();
	}
	
	//create and save new question
	public Questions createQuestion(String q) {
		Questions question = new Questions(q);
		return questionRepo.save(question);
	}
	
	//update question
	public Questions updateQuestion(Questions question) {
		return questionRepo.save(question);
	}
	
	//find questions
	public Questions findQuestion(Long id) {
		Optional<Questions> question = questionRepo.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			return null;
		}
	}
	
}
