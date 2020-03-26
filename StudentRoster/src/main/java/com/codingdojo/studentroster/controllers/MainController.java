package com.codingdojo.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Dorm;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.DormService;
import com.codingdojo.studentroster.services.StudentService;

@Controller
public class MainController {
	//dependency injection
	private final StudentService studentService;
	private final DormService dormService;
	
	public MainController(StudentService studentService, DormService dormService) {
		this.studentService = studentService;
		this.dormService = dormService;
	}
	
	@GetMapping("/students/new")
	public String index(@ModelAttribute("student") Student student) {
		return "/roster/index.jsp";
	}
	
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "/roster/index.jsp";
		}else {
			studentService.createStudent(student);
			return "redirect:/contact/new";
		}
	}
	
	@GetMapping("/contact/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "/roster/contact.jsp";
	}
	
	@PostMapping("/contact/new")
	public String contact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if(result.hasErrors()) {
			return "/roster/contact.jsp";
		}else {
			studentService.createContact(contact);
			return "redirect:/students";
		}
	}
	
	@GetMapping("/students")
	public String show(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "/roster/show.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorms") Dorm dorms) {
		return "/dorms/newDorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String createDorm(@Valid @ModelAttribute("dorms") Dorm dorms, BindingResult result) {
		if(result.hasErrors()) {
			return "/dorms/newDorm.jsp";
		}else {
			dormService.createDorm(dorms);
			return "redirect:/dorms/new";
		}
	}
	
	@GetMapping("/dorms/{id}")
	public String studentDorm(@PathVariable("id") Long dorm_id, @ModelAttribute("dorms") Dorm dorms, Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		Dorm dormOne = dormService.findDorm(dorm_id);
		model.addAttribute("dorms", dormOne);
		return "/dorms/dormList.jsp";
	}
	
	@PostMapping("/dorms/{id}")
	public String addStudentDorm(@PathVariable("id") Long dorm_id, @RequestParam("student") Long student_id, Model model) {
		Dorm dormOne = dormService.findDorm(dorm_id);
		Student student = studentService.findStudent(student_id);
		student.setDorm(dormOne);
		studentService.createStudent(student);
		return "redirect:/dorms/" + dorm_id;
	}
	
	@GetMapping("/dorms/{id}/remove")
	public String removeStudent(@PathVariable("id") Long student_id) {
		Student student = studentService.findStudent(student_id);
		Dorm dorm = student.getDorm();
		Long dormOne_id = dorm.getId();
		student.setDorm(null);
		studentService.createStudent(student);
		return "redirect:/dorms/" + dormOne_id;
	}
}
