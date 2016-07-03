package com.training.annotaion;

import java.lang.reflect.Field;

public class Demo {

	public static void main(String[] args) {
		Class c = Teacher.class;
		Field[] fields = c.getDeclaredFields();
		
		for(Field f:fields) {
			Print p = f.getAnnotation(Print.class);
			if(p!=null) {
				System.out.printf(p.format(), f.getName());
			}
		}
	}

}
