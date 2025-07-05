package com.project.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
 
	@GetMapping("/")
	public String homePage(HttpServletRequest request) {
		return "home"+request.getSession().getId();
	}
	
	@GetMapping("hello")
	public String HelloPage() {
		return "hello";
	}
}
