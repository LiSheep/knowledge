package com.knowledge.timeline;

import java.util.List;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.page.Page;

public class TimelineDateServices implements KnowledgeServices<TimelineDate> {

	@Override
	public int add(TimelineDate t) {
		
		return timelineDateDao.create(t);
	}

	@Override
	public int remove(TimelineDate t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TimelineDate> list(Page<TimelineDate> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimelineDate findEntity(TimelineDate t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimelineDate findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TimelineDate t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(TimelineDate t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private TimelineDateDao timelineDateDao;

	public TimelineDateDao getTimelineDateDao() {
		return timelineDateDao;
	}

	public void setTimelineDateDao(TimelineDateDao timelineDateDao) {
		this.timelineDateDao = timelineDateDao;
	}
}
