package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.UserDtlsRepo;

@RestController
@RequestMapping("/api/sample1")
public class SampleRestController {

	private UserDtlsRepo userDtlsRepo;

	private Employee employee;

	public SampleRestController(UserDtlsRepo userDtlsRepo, @Qualifier("emp2") Employee employee) {
		this.userDtlsRepo = userDtlsRepo;
		this.employee = employee;
	}

	@GetMapping("/emp-count")
	public ResponseEntity<Integer> getEmployeecount() {
		return ResponseEntity.ok(this.userDtlsRepo.testEmpCount());
	}

	@GetMapping("/ex1")
	public String sampleData() {
		return "Sample1 rest api";
	}

	@GetMapping("/ex2")
	public String sampleData2(@RequestParam("first-name") String name) {
		employee.processEmpDtls();
		return "Sample1 rest api ex : 2 ->" + name;
	}

	/**
	 * PostMapping DeleteMapping PutMapping
	 * 
	 * JDBCTemplate RestController RequestMapping ServiceClass
	 * 
	 * 
	 * Front End Angular
	 * 
	 * Hibernate
	 * 
	 * DB select insert update join -> left , right , inner , union, intersection
	 * delete truncate
	 * 
	 * 
	 * Swagger - Open -api
	 * 
	 */

}
