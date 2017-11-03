package com.project.counter.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CountController{
	//Member variables go here

	public CountController(){

	}
	
	@RequestMapping("")
	public String index(HttpSession session, Model model){
		if (session.getAttribute("count") == null){
			int count = 0;
			session.setAttribute("count", count);
		}
		int count = ((int) session.getAttribute("count"));
		count += 1;
		session.setAttribute("count", count);
		model.addAttribute("count", session.getAttribute("count"));

		return "index";
	}
	@RequestMapping("/rest")
	public String rest(HttpSession session){
		int count = 0;
		session.setAttribute("count", count);
		return "redirect:/";
	}
	@RequestMapping("/2")
	public String addTwo(HttpSession session){
		int count = ((int) session.getAttribute("count"));
		count += 1;
		session.setAttribute("count", count);
		return "redirect:/";
	}
}
