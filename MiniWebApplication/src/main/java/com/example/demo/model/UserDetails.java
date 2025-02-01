package com.example.demo.model;

import jakarta.persistence.Table;

//@Entity
//@Table(name = )
public class UserDetails {    

//	@Id
	private int id;
	private String name; 
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + "]";
	}

	
}
