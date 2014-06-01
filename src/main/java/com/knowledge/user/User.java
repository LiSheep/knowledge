package com.knowledge.user;

import com.knowledge.arc.KnowledgeEntity;

public class User extends KnowledgeEntity {
	private String username;

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

	
	
}
