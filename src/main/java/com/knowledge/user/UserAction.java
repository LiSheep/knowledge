package com.knowledge.user;

import com.knowledge.arc.KnowledgeAction;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends KnowledgeAction<User> {
	
	//TODO : log must be do
//	private static final Logger logger = Logger.getLogger( UserAction.class.getName() );
	/**
	 * User action for process User do
	 */
	private static final long serialVersionUID = 8335062372139836975L;
	
	public String login() throws Exception {
		User user = userServices.findEntity(getModel());
		
		if (null != user) {
			ActionContext.getContext().getSession().put("user", user);
			
			return SUCCESS;
		}
			
		
		return INPUT;
	}
	
	public String register() {
		if (model.getUsername().length() >= Integer.valueOf(getText("username.length.min")) 
				&& model.getUsername().length() <= Integer.valueOf(getText("username.length.max"))) {
			if (model.getUserpass().length() >= Integer.valueOf(getText("userpass.length.min")) 
					&& model.getUserpass().length() <= Integer.valueOf(getText("userpass.length.max"))) {
				if (1 == userServices.add(getModel())) {
					return SUCCESS;
				} else {
					return INPUT;
				}
			}
		}
		return INPUT;
	}
	
	private User model;
	
	@Override
	public User getModel() {
		if (null == model) {
			model = new User();
		}
		return model;
	}
	
	private UserServices userServices;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
}
