package com.codingdojo.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Tags;

@Repository
public interface TagRepository extends CrudRepository<Tags, Long> {
	//find all tags
	List<Tags> findAll();
	
	Tags findTagBySubject(String subject);
	
	Optional<Tags> findById(Long id);
}
