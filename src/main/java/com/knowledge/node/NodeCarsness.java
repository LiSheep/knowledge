package com.knowledge.node;

import com.knowledge.arc.KnowledgeEntity;

public class NodeCarsness extends KnowledgeEntity {
	private String knowName;
	private int knowType;    //dictionary fieldCode 2
	private int knowOrder; 
	private int knowImportance; //dictionary fieldCode 3
	private int knowComplexity; //dictionary fieldCode 4
	private String knowDescription;
	
	public String getKnowName() {
		return knowName;
	}
	public void setKnowName(String knowName) {
		this.knowName = knowName;
	}
	public int getKnowType() {
		return knowType;
	}
	public void setKnowType(int knowType) {
		this.knowType = knowType;
	}
	public int getKnowOrder() {
		return knowOrder;
	}
	public void setKnowOrder(int knowOrder) {
		this.knowOrder = knowOrder;
	}
	public int getKnowImportance() {
		return knowImportance;
	}
	public void setKnowImportance(int knowImportance) {
		this.knowImportance = knowImportance;
	}
	public int getKnowComplexity() {
		return knowComplexity;
	}
	public void setKnowComplexity(int knowComplexity) {
		this.knowComplexity = knowComplexity;
	}
	public String getKnowDescription() {
		return knowDescription;
	}
	public void setKnowDescription(String knowDescription) {
		this.knowDescription = knowDescription;
	}
}
