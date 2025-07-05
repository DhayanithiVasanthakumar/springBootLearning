package com.project.main.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PublicController {

	@GetMapping("/public/demo")
	public String publicDemo() {
		return "public demo page";
	}
	
}
