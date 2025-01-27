package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.value.ValueAnnotation;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")

public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
		Home h=context.getBean(Home.class);
		h.connect();
		
		//use @value annotation
		
		ValueAnnotation va=new ValueAnnotation();
		System.out.println(va.getDefaultName());
		System.out.println(va.getEmail());
		System.out.println(va.getHost());
		System.out.println(va.getPassword());
		
	}

}
