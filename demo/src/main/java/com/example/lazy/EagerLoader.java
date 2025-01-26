package com.example.lazy;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EagerLoader {

	@Autowired
	public String eagerLoader() {
		return "from eagerLoader";
	}
}
