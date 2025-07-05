package com.project.main.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.main.model.Users;
import com.project.main.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AdminController {

	@Autowired
	UserService userService;
	
	@PostMapping("/admin/add-user")
	public void addUser(@RequestBody Users user) {
		userService.addUser(user);
	}
	
}
