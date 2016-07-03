package com.training.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PrintInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public PrintInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(method.getName()+ " is invoking!");
		
		return method.invoke(target, args);
	}

}
