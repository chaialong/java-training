package com.training.day3.spring.dao;

public class Loan {
	private int id;
	private String name;
	private int year;

	public Loan() {
		super();
	}

	public Loan(int id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
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

	@Override
	public String toString() {
		return "Loan [id=" + id + ", name=" + name + ", year=" + year + "]";
	}

	public void setYear(int year) {
		this.year = year;
	}
}
