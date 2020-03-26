package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository<Languages, Long> {
	// this method retrieves all the languages from the database
	List<Languages> findAll();
	
	 // this method finds languages with descriptions containing the search string
//	List<Languages> findByDescriptionContinaing(String search);
	
    // this method deletes a language that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
