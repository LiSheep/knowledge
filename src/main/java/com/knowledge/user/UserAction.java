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
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
