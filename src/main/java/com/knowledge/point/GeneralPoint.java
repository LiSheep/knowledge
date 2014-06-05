package com.knowledge.point;

import com.knowledge.arc.KnowledgeEntity;

public class GeneralPoint extends KnowledgeEntity {
	String pointName;
	String pointDescrible;
	String pointDetail;
	int pointType;
	int orderNum;
	int importance;	//3
	int complexity;	//4
	
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
	public String getPointDetail() {
		return pointDetail;
	}
	public void setPointDetail(String pointDetail) {
		this.pointDetail = pointDetail;
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
	public String getPointDescrible() {
		return pointDescrible;
	}
	public void setPointDescrible(String pointDescrible) {
		this.pointDescrible = pointDescrible;
	}
	@Override
	public String getTableName() {
		return "knowledge_point_general";
	}
}
