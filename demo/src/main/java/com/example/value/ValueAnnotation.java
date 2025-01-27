package com.example.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation {

	@Value("default name")
	private String defaultName;
	
	//using ${key} form application property
	
	@Value("${mail.host}")
	private String host;
	
	@Value("${mail.email}")
	private String email;
	
	@Value("${mail.password}")
	private String password;
	

	public String getDefaultName() {
		return defaultName;
	}

	public String getHost() {
		return host;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
}
