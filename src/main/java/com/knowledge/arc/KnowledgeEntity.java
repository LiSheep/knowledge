package com.knowledge.arc;

public abstract class KnowledgeEntity {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract String getTableName();
	
}
