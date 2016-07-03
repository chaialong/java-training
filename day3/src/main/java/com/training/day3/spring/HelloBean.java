package com.training.day3.spring;

import java.util.List;

public class HelloBean {
	private String msg;
	private List books;

	public HelloBean(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		System.out.println("in getMsg");
		if(true) throw new RuntimeException("msg exception");
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List getBooks() {
		return books;
	}

	public void setBooks(List books) {
		this.books = books;
	}
}
