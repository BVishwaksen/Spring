package com.sunsoft;

public class Book {
	
	private int id;
	private String name;
	private int year;
	private String publisher;
	private String author;
	
	public Book() {
		
	}
	
	public Book(int id, String name, int year,String publisher,String author) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.publisher = publisher;
		this.author = author;
	}
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
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\tYear : "+this.getYear()
		+"\tPublisher : "+this.getPublisher()+"\tAuthor : "+this.getAuthor();
	}
	
}