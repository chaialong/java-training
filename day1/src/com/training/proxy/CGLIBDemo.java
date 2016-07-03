package com.training.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBDemo {

	public static void main(String[] args) {
		final ArrayList list = new ArrayList();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ArrayList.class);
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args,
					MethodProxy proxy) throws Throwable {
				System.out.println(method.getName()+" is invoking!");
				return method.invoke(list, args);
			}
			
		});
		
		ArrayList proxy = (ArrayList) enhancer.create();
		proxy.add("test");
		System.out.println(proxy.getClass());
		System.out.println(list.size());
	}

}
