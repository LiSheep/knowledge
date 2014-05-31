package com.knowledge.point;

import com.knowledge.arc.KnowledgeEntity;

public class DetailPoint extends KnowledgeEntity {

	String pointName;
	int importance;
	int complexity;
	String generalKey;
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
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
	public String getGeneralKey() {
		return generalKey;
	}
	public void setGeneralKey(String generalKey) {
		this.generalKey = generalKey;
	}
	
}
