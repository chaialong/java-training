package com.training.reflect;

public class Student {
	private int id;
	
	public void print() {
		System.out.println("i am a student!");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
}
