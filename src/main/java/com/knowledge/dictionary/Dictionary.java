package com.knowledge.dictionary;

import com.knowledge.arc.KnowledgeEntity;

public class Dictionary extends KnowledgeEntity {
	private int fieldCode;
	private String fieldName;
	private int code;
	private String label;
	private int orderNum;
	
	public int getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(int fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String getTableName() {
		return "knowledge_dictionary";
	}
}
