package com.knowledge.point;

import java.util.List;

import com.knowledge.arc.KnowledgeEntity;

public class GeneralPoint extends KnowledgeEntity {
	private String pointName;
	private String pointDescrible;
	private String pointDetail;
	private int pointType;
	private int orderNum;
	private int importance;	//3
	private int complexity;	//4
	
	private List<DetailPoint> detailPoints;
	
	public List<DetailPoint> getDetailPoints() {
		return detailPoints;
	}
	public void setDetailPoints(List<DetailPoint> detailPoints) {
		this.detailPoints = detailPoints;
	}
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
