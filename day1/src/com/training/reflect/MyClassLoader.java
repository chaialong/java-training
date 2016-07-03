package com.training.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
	
	private String classpath = "F:/workspace/training/20160618/day1/bin/";

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if(name.startsWith("java")) return super.loadClass(name);
		
		String path = classpath + name.replace(".", "/") + ".class";
		Class clazz = null;
		try {
			InputStream in = new FileInputStream(path);
			byte[] buf = new byte[in.available()];
			in.read(buf);
			clazz = this.defineClass(name, buf, 0, buf.length);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clazz = super.loadClass(name);
		}
		return clazz;
	}

	public static void main(String[] args) throws Exception {
		ClassLoader lc = new MyClassLoader();
		Class c = lc.loadClass("com.training.day1.Student");
		Method printMethod = c.getMethod("print");
		Object o = c.newInstance();
		printMethod.invoke(o);
		
		System.out.println(o.getClass());
		System.out.println(o instanceof Student);
	}

}
