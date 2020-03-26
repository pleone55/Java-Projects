package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answers;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	//dependency injection
	private final AnswerRepository answerRepo;
	
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	//return all answers
	public List<Answers> allAnswers(){
		return answerRepo.findAll();
	}
	
	//create and save answers
	public Answers createAnswer(Answers a) {
		return answerRepo.save(a);
	}
	
	//find an answer
	public Answers findAnswer(Long id) {
		Optional<Answers> answer = answerRepo.findById(id);
		if(answer.isPresent()) {
			return answer.get();
		}else {
			return null;
		}
	}
}
