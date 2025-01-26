package com.project.pojo;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


public class Book {

	
	public Book(int id, String book, String description) {
		this.id = id;
		this.book = book;
		this.description = description;
	}
	public Book() {

	}
	private int id;
	private String book;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
