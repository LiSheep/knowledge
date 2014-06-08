package com.knowledge.compute;

import com.knowledge.arc.KnowledgeEntity;

public class Compute extends KnowledgeEntity {
	private String generalKey;
	private int importance;
	private int complexity;

	public String getGeneralKey() {
		return generalKey;
	}

	public void setGeneralKey(String generalKey) {
		this.generalKey = generalKey;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}
}
