package com.knowledge.interceptor;

import com.knowledge.user.UserServices;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	
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
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (null != userServices.findUserSession()) {
			
			return invocation.invoke();
		}
		
		return "nologin";
	}
}
