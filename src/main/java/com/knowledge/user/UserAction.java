package com.knowledge.user;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private static final Logger logger = Logger.getLogger( UserAction.class.getName() );
	/**
	 * User action for process User do
	 */
	private static final long serialVersionUID = 8335062372139836975L;
	
	public String login() throws Exception {
		logger.warn("test");
		return SUCCESS;
	}
	
	private User model;

	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
}
