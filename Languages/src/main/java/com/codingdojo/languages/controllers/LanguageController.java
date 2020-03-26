package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Languages language) {
		List<Languages> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Languages language) {
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.GET)
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Languages languages = languageService.findLanguage(id);
		model.addAttribute("languages", languages);
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Languages language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{languageId}", method=RequestMethod.PUT)
	public String update(@PathVariable("languageId") Long languageId, @Valid @ModelAttribute("language") Languages language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		}else {
			System.out.println(language.getId());
//			language.setId(languageId);
			languageService.createLanguage(language);
//			languageService.updateLanguage(language.getId(), language.getName(), language.getCreator(), language.getCurrentVersion());
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}

}
