package com.knowledge.aop.role;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AspectRoleAuth implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("after");
		
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("before");
		
	}
	
	public void afterThrowing(Exception ex) {
		System.out.println("after throwing");
	}
}
