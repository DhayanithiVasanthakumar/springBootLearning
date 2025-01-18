package com.example.demo;

import org.springframework.stereotype.Component;

@Component("test")
public class InternetConnection {

	private String idAddress;
	private int speed;
	
	public String getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(String idAddress) {
		this.idAddress = idAddress;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public void switchOn() {
		System.out.println("Switching on internet...");
	}
}
