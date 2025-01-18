package com.example.demo;

import org.springframework.stereotype.Component;

@Component("emp2")
public class EmployeeComponentEx2 implements Employee {

	@Override
	public void processEmpDtls() {
		System.out.println("Process emp 2");
	}

}
