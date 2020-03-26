package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojooverflow.models.Questions;
import com.codingdojo.dojooverflow.models.Tags;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	//dependency injection
	private final QuestionService questService;
	private final TagService tagService;
	
	public QuestionController(QuestionService questService, TagService tagService) {
		this.questService = questService;
		this.tagService = tagService;
	}
	
	@GetMapping("/questions")
	public String questionDashboard(Model model) {
		List<Questions> questions = questService.allQuestions();
		model.addAttribute("questions", questions);
		return "/questions/dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(Model model, @ModelAttribute("questions") Questions questions) {
		model.addAttribute("questions", questions);
		return "/questions/newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam(value="question") String question, @RequestParam(value="tags") String tags, RedirectAttributes redirect) {
		String smallTags = tags.toLowerCase();
		String[] listTags = smallTags.split(",");
		List<String> allTags = Arrays.asList(listTags);
		
		//if question is empty
		if(question.isEmpty()) {
			redirect.addFlashAttribute("question", "Question must be answered");
			return "/questions/newQuestion.jsp";
		}else if(tags.length() < 1) {
			redirect.addFlashAttribute("tag", "Question must be more than one character");
			return "/questions/newQuestion.jsp";
		}else if(allTags.size() > 3) {
			redirect.addFlashAttribute("tag", "Cannot have more than 3 tags");
			return "/questions/newQuestion.jsp";
		}else {
			Questions q = questService.createQuestion(question);
			ArrayList<Tags> qtc = new ArrayList<Tags>();
			
			for(int i = 0; i < allTags.size(); i++) {
				Tags findTag = tagService.findTagBySubject(allTags.get(i));
				if(findTag == null) {
					Tags t = tagService.createStringTag(allTags.get(i));
					qtc.add(t);
				}else {
					qtc.add(findTag);
				}
			}
			
			q.setTags(qtc);
			questService.updateQuestion(q);
			return "redirect:/questions";
		}
	}
}
