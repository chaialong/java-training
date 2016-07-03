package com.training.reflect;

import java.lang.reflect.Field;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Object o = new Student();
		
		Class c = o.getClass();
		Field f = c.getDeclaredField("id");
		f.setAccessible(true);
		f.set(o, 100);
		
		System.out.println(o);
	}

}
