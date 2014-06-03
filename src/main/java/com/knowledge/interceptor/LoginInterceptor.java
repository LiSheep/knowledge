package com.knowledge.interceptor;

import com.knowledge.user.UserServices;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	
	/**
	 * 连接用户是否登录
	 */
	private static final long serialVersionUID = -1867369566281699155L;
	private UserServices userServices;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if (null == userServices.findUserSession()) {
			return "nologin";
		}
		
		return invocation.invoke();
	}
}
