package com.knowledge.comment;

import java.sql.Timestamp;

import com.knowledge.arc.KnowledgeEntity;
import com.knowledge.point.DetailPoint;
import com.knowledge.point.GeneralPoint;
import com.knowledge.user.User;

public class Comment extends KnowledgeEntity {
	
	private int importance;	//知识点重要程度-> dictionary:fieldCode=3
	private int complexity;	//知识点难易程度-> dictionary:fieldCode=4
	private String comment;
	private String note;
	private Timestamp updateTime;

	private User user;
	
	private GeneralPoint generalPoint;
	private DetailPoint detailPoint;
	
	public GeneralPoint getGeneralPoint() {
		if(generalPoint == null)
			generalPoint = new GeneralPoint();
		return generalPoint;
	}
	public void setGeneralPoint(GeneralPoint generalPoint) {
		this.generalPoint = generalPoint;
	}
	public DetailPoint getDetailPoint() {
		if(detailPoint == null)
			detailPoint = new DetailPoint();
		return detailPoint;
	}
	public void setDetailPoint(DetailPoint detailPoint) {
		this.detailPoint = detailPoint;
	}
	public User getUser() {
		if(user == null)
			user = new User();
		return this.user;
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
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
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
