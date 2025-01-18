package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //it used to create an object in Spring Container
public class Home {

	//POJO class
	
	private String owner;
	private String doorNo;
	
	@Autowired //for to connect two component 
	@Qualifier("test") //use when having more than two component 
	private InternetConnection moderm;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	
	public void connect() {
		moderm.switchOn();
		System.out.println("Connecting to internet...");
	}
}
