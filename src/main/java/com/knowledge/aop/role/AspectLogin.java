package com.knowledge.aop.role;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.knowledge.exception.NoLoginException;
import com.knowledge.user.UserServices;

public class AspectLogin implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws NoLoginException {
		if (null == userServices.findUserSession()) {
			System.out.println("aop before method");
			//TODO
		}
		
		try {
			arg0.invoke(arg2, arg1);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void afterThrowing(Exception ex) {
		System.out.println("after throwing");
	}
	
	private UserServices userServices;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
}
