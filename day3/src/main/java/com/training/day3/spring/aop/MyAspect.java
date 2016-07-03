package com.training.day3.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	@Before("execution(* com..HelloBean.getMsg(..))")
	public void test() {
		System.out.println("in before advice!");
	}
	
	@AfterReturning(pointcut="execution(* com..HelloBean.getMsg(..))",
			returning="value")
	public void aftest(String value) {
		System.out.println("return:"+value);
	}
	
	@Around("execution(* com..HelloBean.getMsg(..))")
	public Object roundtest(ProceedingJoinPoint point) throws Throwable {
		//...
		System.out.println("in around before!");
		Object r = point.proceed();
		System.out.println("in around after!");
		//...
		return r;
	}
	
	@AfterThrowing(pointcut="execution(* com..HelloBean.getMsg(..))",
			throwing="e")
	public void attest(Exception e) {
		System.out.println("an exeption catched:"+e.getMessage());
	}
}



