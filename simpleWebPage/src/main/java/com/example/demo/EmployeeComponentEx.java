package com.example.demo;

import org.springframework.stereotype.Component;

@Component("emp1")
public class EmployeeComponentEx implements Employee {

	@Override
	public void processEmpDtls() {
		System.out.println("Process emp 1");
	}

}
