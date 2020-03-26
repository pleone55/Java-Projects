package com.codingdojo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Dorm;
import com.codingdojo.studentroster.repositories.DormRepository;

@Service
public class DormService {
	//dependency injection
	private final DormRepository dormRepo;
	
	public DormService(DormRepository dormRepo) {
		this.dormRepo = dormRepo;
	}
	
	//Return all dorms
	public List<Dorm> allDorms(){
		return dormRepo.findAll();
	}
	
	//create and save dorm
	public Dorm createDorm(Dorm d) {
		return dormRepo.save(d);
	}
	
	//find dorm
	public Dorm findDorm(Long id) {
		Optional<Dorm> dorm = dormRepo.findById(id);
		if(dorm.isPresent()) {
			return dorm.get();
		}else {
			return null;
		}
	}
	
}
