package com.knowledge.timeline;

import com.knowledge.arc.KnowledgeEntity;

public class TimelineAsset extends KnowledgeEntity {
	private String media;
	private String credit;
	private String caption;
	
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "knowledge_tieline_asset";
	}
}
