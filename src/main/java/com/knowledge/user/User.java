package com.knowledge.user;

import java.sql.Date;

import com.knowledge.arc.KnowledgeEntity;

public class User extends KnowledgeEntity {
	private String username;
	private String userpass;
	private Date regTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
}
