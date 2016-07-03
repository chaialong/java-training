package com.training.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyDemo {

	public static void main(String[] args) {
		final ArrayList list = new ArrayList();
		InvocationHandler handler = new PrintInvocationHandler(list);
		List proxy = (List)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				new Class[]{List.class}, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println(method.getName()+ " is invoking!");
						
						return method.invoke(list, args);
					}
			
		});
		
		System.out.println(proxy.getClass());
		proxy.add("test");
		System.out.println(list.size());
	}

}
