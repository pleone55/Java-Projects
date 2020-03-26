package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class GoldController {
	
	//@GetMapping
	@RequestMapping("/gold")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("log", new ArrayList<String>());
		}
		return "gold.jsp";
	}
	
	//generate random number of gold
	public int getRandomGold(int max, int min) {
		Random rand = new Random();
		int value = rand.nextInt((max-min)+1)+min;
		return value;
	}
	
	//@PostMapping
	@RequestMapping(value="/process-money", method=RequestMethod.POST)		
	public String gold(HttpSession session, @RequestParam(value="candy") String candy) {
		Date timeStamp = new Date();
		
		if(candy.equals("farm")) {
			Integer randGold = getRandomGold(20, 10);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold + randGold);
			((ArrayList<String>) session.getAttribute("log")).add("You entered a farm and earned "+ randGold +" gold. ("+ timeStamp +")");
		}
		
		else if(candy.equals("cave")) {
			Integer randGold = getRandomGold(10, 5);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold + randGold);
			((ArrayList<String>) session.getAttribute("log")).add("You entered a cave and earned "+ randGold +" gold. ("+ timeStamp +")");
		}
		
		else if(candy.equals("house")) {
			Integer randGold = getRandomGold(5, 2);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold + randGold);
			((ArrayList<String>) session.getAttribute("log")).add("You entered a house and earned "+ randGold +" gold. ("+ timeStamp +")");
		}
		
		else if(candy.equals("casino")) {
			Integer randGold = getRandomGold(50, -50);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold + randGold);
			if(randGold < 0) {
				((ArrayList<String>) session.getAttribute("log")).add("You entered a Casino and lost "+ randGold +" gold. ("+ timeStamp +")");
			}else {
				((ArrayList<String>) session.getAttribute("log")).add("You entered a Casino and won "+ randGold +" gold. ("+ timeStamp +")");
			}
		}	
		
		return "redirect:/gold";
	}
	
	//@GetMapping
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		Integer gold = (Integer) session.getAttribute("gold");
		((ArrayList<String>) session.getAttribute("log")).clear();
		return "redirect:/gold";
	}
}
