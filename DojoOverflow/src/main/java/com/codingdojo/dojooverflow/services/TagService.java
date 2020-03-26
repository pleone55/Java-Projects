package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tags;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	//dependency injection
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	//return all tags
	public List<Tags> allTags(){
		return tagRepo.findAll();
	}
	
	//create and save tags
	public Tags createTag(Tags t) {
		return tagRepo.save(t);
	}
	
	//create String tags
	public Tags createStringTag(String t) {
		Tags newTag = new Tags(t);
		return tagRepo.save(newTag);
	}
	
	//find all tags
	public Tags findTags(Long id) {
		Optional<Tags> tag = tagRepo.findById(id);
		if(tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
	
	//find tags by subject containing
	public Tags findTagBySubject(String sub) {
		return tagRepo.findTagBySubject(sub);
	}
	
}
