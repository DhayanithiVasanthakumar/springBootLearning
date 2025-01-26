package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.configExample.Customer;

@Configuration
public class CustomerConfigController {

	@Bean("customerBean")
	public Customer getCustomerBean() {
		return new Customer();//Customer class vanthu core java class so athu spring container la irukathu 
								//so manual ah spring container la bean create panarom
	}
}
