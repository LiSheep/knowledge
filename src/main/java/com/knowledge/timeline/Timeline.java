package com.knowledge.timeline;

import java.util.List;

import com.knowledge.arc.KnowledgeEntity;

public class Timeline extends KnowledgeEntity {
	private String headline;
	private String type;
	private String text;
	private String startDate;
	private List<TimelineDate> date;
	private String userKey;
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public List<TimelineDate> getDate() {
		return date;
	}
	public void setDate(List<TimelineDate> date) {
		this.date = date;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "knowledge_timeline_headline";
	}
}
