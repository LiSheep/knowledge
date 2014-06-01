package com.knowledge.comment;

import java.util.Date;

import com.knowledge.arc.KnowledgeEntity;
import com.knowledge.user.User;

public class Comment extends KnowledgeEntity {
	
	private int importance;	//知识点重要程度-> dictionary:fieldCode=3
	private int complexity;	//知识点难易程度-> dictionary:fieldCode=4
	private String comment;
	private String note;
	private Date updateTime;

	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	@Override
	public String getTableName() {
		return "knowledge_point_comment";
	}
}
