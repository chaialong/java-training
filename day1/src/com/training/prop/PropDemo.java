package com.training.prop;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

public class PropDemo {

	public static void main(String[] args) throws Exception { 
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/training/prop/test.properties");
		Properties prop = new Properties();
		prop.load(in);
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		in.close();
		prop.setProperty("username", "root");
		prop.store(new FileWriter("d:/1.properties"), "test");
		
	}

}
