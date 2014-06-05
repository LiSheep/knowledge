package com.knowledge.timeline;

import java.util.List;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.page.Page;

public class TimelineAssetServices implements KnowledgeServices<TimelineAsset> {

	@Override
	public int add(TimelineAsset t) {
		
		return timelineAssetDao.create(t);
	}

	@Override
	public int remove(TimelineAsset t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TimelineAsset> list(Page<TimelineAsset> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimelineAsset findEntity(TimelineAsset t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimelineAsset findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TimelineAsset t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(TimelineAsset t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private TimelineAssetDao timelineAssetDao;

	public TimelineAssetDao getTimelineAssetDao() {
		return timelineAssetDao;
	}

	public void setTimelineAssetDao(TimelineAssetDao timelineAssetDao) {
		this.timelineAssetDao = timelineAssetDao;
	}
}
