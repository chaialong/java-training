package com.training.day3.spring;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Integer(10);
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return Integer.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
