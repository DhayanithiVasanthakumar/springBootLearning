package com.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.main.model.Users;
import com.project.main.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public void adduser(@RequestBody Users user) {
		userService.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
	
		return userService.verify(user);
	}
}
