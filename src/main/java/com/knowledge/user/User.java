package com.knowledge.user;

import java.sql.Timestamp;
import java.util.Date;

import com.knowledge.arc.KnowledgeEntity;

public class User extends KnowledgeEntity {
	private String username;
	private String userpass;
	private Timestamp regTime;
	private int role;

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

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
