package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	//adding the language repository as a dependency
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	//return all languages
	public List<Languages> allLanguages(){
		return languageRepository.findAll();
	}
	
	//create a language
	public Languages createLanguage(Languages l) {
		return languageRepository.save(l);
	}
	
	//find a language
	public Languages findLanguage(Long id) {
		Optional<Languages> lang = languageRepository.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		}else {
			return null;
		}
	}
	
	//edit a language
	public Languages updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Languages> lang = languageRepository.findById(id);
		if(lang.isPresent()) {
			Languages updateLanguage = lang.get();
			updateLanguage.setName(name);
			updateLanguage.setCreator(creator);
			updateLanguage.setCurrentVersion(currentVersion);
			return languageRepository.save(updateLanguage);
		}else {
			return null;
		}
	}
	
	//delete a language
	public void destroyLanguage(Long id) {
		Optional<Languages> lang = languageRepository.findById(id);
		if(lang.isPresent()) {
			languageRepository.deleteById(id);
		}
	}
}
