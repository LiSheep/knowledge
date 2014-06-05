package com.knowledge.timeline;

import com.knowledge.arc.KnowledgeEntity;

public class TimelineDate extends KnowledgeEntity {
	private String startDate;
	private String endDate;
	private String headline;
	private String text;
	private TimelineAsset asset;
	private String headlineKey;
	private String assetKey;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public TimelineAsset getAsset() {
		return asset;
	}
	public void setAsset(TimelineAsset asset) {
		this.asset = asset;
	}
	public String getHeadlineKey() {
		return headlineKey;
	}
	public void setHeadlineKey(String headlineKey) {
		this.headlineKey = headlineKey;
	}
	public String getAssetKey() {
		return assetKey;
	}
	public void setAssetKey(String assetKey) {
		this.assetKey = assetKey;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "knowledge_timeline_date";
	}
}
