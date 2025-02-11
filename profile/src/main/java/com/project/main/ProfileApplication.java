package com.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project")
public class ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}

}
