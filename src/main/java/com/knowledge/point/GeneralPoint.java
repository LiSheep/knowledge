package com.knowledge.point;

import com.knowledge.arc.KnowledgeEntity;

public class GeneralPoint extends KnowledgeEntity {
	String pointName;
	int pointType;
	int orderNum;
	int importance;
	int complexity;
	
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public int getPointType() {
		return pointType;
	}
	public void setPointType(int pointType) {
		this.pointType = pointType;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
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
		return "knowledge_point_general";
	}
}
