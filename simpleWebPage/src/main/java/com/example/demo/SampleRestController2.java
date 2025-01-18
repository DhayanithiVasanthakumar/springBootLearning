package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleRestController2 {

	@GetMapping("/ex1")
	public String sampleData() {
		return "Sample rest api";
	}
	

	@GetMapping("/ex2")
	public String sampleData2() {
		return "Sample rest api ex : 2";
	}

}
