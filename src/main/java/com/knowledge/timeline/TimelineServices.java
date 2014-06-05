package com.knowledge.timeline;

import java.util.List;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.page.Page;

public class TimelineServices implements KnowledgeServices<Timeline> {

	@Override
	public int add(Timeline t) {
		t.setType("default");
		
		return timelineDao.create(t);
	}

	@Override
	public int remove(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Timeline findEntity(Timeline t) {
		// TODO Auto-generated method stub
		return null;
	}

	//根据userId查询出与这个用户相关的Timeline
	public Timeline findEntityById(String id) {
		Timeline timeline = timelineDao.readByUser(id);
		timeline.setDate(timelineDateDao.readByHeadlineKey(timeline.getId()));
		
		return timeline;
	}

	@Override
	public int update(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private TimelineDao timelineDao;

	public TimelineDao getTimelineDao() {
		return timelineDao;
	}

	public void setTimelineDao(TimelineDao timelineDao) {
		this.timelineDao = timelineDao;
	}
	
	private TimelineDateDao timelineDateDao;

	public TimelineDateDao getTimelineDateDao() {
		return timelineDateDao;
	}

	public void setTimelineDateDao(TimelineDateDao timelineDateDao) {
		this.timelineDateDao = timelineDateDao;
	}

	@Override
	public Timeline findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Timeline> list(Page<Timeline> page) {
		// TODO Auto-generated method stub
		return null;
	}
}
