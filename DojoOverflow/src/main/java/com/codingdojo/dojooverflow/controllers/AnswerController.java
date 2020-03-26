package com.codingdojo.dojooverflow.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojooverflow.models.Answers;
import com.codingdojo.dojooverflow.models.Questions;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;

@Controller
public class AnswerController {
	//dependency injection
	private final AnswerService answerService;
	private final QuestionService questService;
	
	public AnswerController(AnswerService answerService, QuestionService questService) {
		this.answerService = answerService;
		this.questService = questService;
	}
	
	@GetMapping("/questions/{id}")
	public String answers (Model model, @PathVariable("id") Long id) {
		Questions question = questService.findQuestion(id);
		model.addAttribute("question", question);
		return "answers/newAnswer.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String answerQuestion (@PathVariable("id") Long id,
			@RequestParam (value = "answer") String answer, HttpSession session) {
		if (answer.length() < 2) {
			session.setAttribute("id", id);
			return "/answers/newAnswer.jsp";
		}
		else {
			Answers a = new Answers();
			a.setAnswer(answer);
			Questions question = questService.findQuestion(id);
			a.setQuestion(question);
			answerService.createAnswer(a);
			return "redirect:/questions/" + id;
		}
	}
	
//	@GetMapping("/questions/{id}")
//	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answers answer, Model model) {
//		Questions question = questService.findQuestion(id);
//		model.addAttribute("answer", answer);
//		model.addAttribute("question", question);
//		model.addAttribute("tags", question.getTags());
//		return "/answers/newAnswer.jsp";
//	}
//	
//	@PostMapping("/questions/{id}")
//	public String addAnswer(@Valid @ModelAttribute("answer") Answers answer, BindingResult result) {
//		if(result.hasErrors()) {
//			return "/answers/newAnswer.jsp";
//		}else {
//			answerService.createAnswer(answer);
//			return "redirect:/questions/{id}";
//		}
//	}
}
