package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.configExample.Customer;

@RestController
public class CustomerController {

	@Autowired //-> auto wire pana mudiyathu because Customer class outside the package apram athu plain core java program 
	//so athu spring container la irukathu ,so namba configuration class write pani atha kontu varanum like->CustomerConfigController
	public Customer customer;
	
	@GetMapping("/customer")
	public String getInfo() {
		return customer.getCustomer();
	}
}
