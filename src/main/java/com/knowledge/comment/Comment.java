package com.knowledge.comment;

import com.knowledge.arc.KnowledgeEntity;

public class Comment extends KnowledgeEntity {
	private String fineKey;
	
	private int complexity;
	private int importance;
	private String comment;
	private String suggestion;
	private String reason;
	
	public String getFineKey() {
		return fineKey;
	}
	public void setFineKey(String fineKey) {
		this.fineKey = fineKey;
	}
	public int getComplexity() {
		return complexity;
	}
	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
