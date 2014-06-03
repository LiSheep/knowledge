package com.knowledge.interceptor;

import com.knowledge.user.UserServices;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class RoleInterceptor extends MethodFilterInterceptor {

	/**
	 * 拦截add update and delete method for manager only
	 */
	private static final long serialVersionUID = -5255814109136676742L;
	private UserServices userServices;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		if (1 == userServices.findUserSession().getRole()) {
			return invocation.invoke();
		}
		
		return "permission";
	}

}
