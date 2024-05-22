package com.albertsalud.springsecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping
	public String goHome(Model model) {
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication authentication = sc.getAuthentication();
		User user = (User) authentication.getPrincipal();
		
		model.addAttribute("user", user.getUsername());
		
		return "home.html";
	}

}
