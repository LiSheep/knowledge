package com.knowledge.timeline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.common.DataConvUtil;

public class TimelineDateDao extends KnowledgeDao<TimelineDate> {

	@Override
	public int create(TimelineDate t) {
		String sql = "INSERT INTO knowledge_timeline_date (id, text, headline, asset, headlineKey) VALUES (?, ?, ?, ?, ?)";
		Object[] args = {t.getId(), t.getText(), t.getHeadline(), t.getAssetKey(), t.getHeadlineKey()};
		
		return jdbcTemplate.update(sql, args);
	}
	
	public List<TimelineDate> readByHeadlineKey(String headlineKey) {
		StringBuffer buffer = new StringBuffer("SELECT id, text, headline, startDate, endDate, asset FROM knowledge_timeline_date WHERE headlineKey=?");
		Object[] args = {headlineKey};
		
		return jdbcTemplate.query(buffer.toString(), new TimelineDateRowMapper(timelineAssetDao), args);
	}

	@Override
	public int deleteEntity(TimelineDate t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntity(TimelineDate t) {
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

	@Override
	public TimelineDate readEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
}

class TimelineDateRowMapper implements RowMapper<TimelineDate> {
	private TimelineAssetDao timelineAssetDao;
	
	public TimelineAssetDao getTimelineAssetDao() {
		return timelineAssetDao;
	}

	public void setTimelineAssetDao(TimelineAssetDao timelineAssetDao) {
		this.timelineAssetDao = timelineAssetDao;
	}
	
	public TimelineDateRowMapper(TimelineAssetDao timelineAssetDao) {
		this.timelineAssetDao = timelineAssetDao;
	}

	@Override
	public TimelineDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimelineDate date = new TimelineDate();
		
		date.setId(rs.getString("id"));
		date.setAsset(timelineAssetDao.readOne(rs.getString("asset")));
//		end is NULL ?
		if (null == rs.getDate("endDate")) {
			date.setEndDate("");
		} else {
			date.setEndDate(DataConvUtil.dateFormatJson(rs.getDate("endDate")));
		}
		date.setStartDate(DataConvUtil.dateFormatJson(rs.getDate("startDate")));
		date.setHeadline(rs.getString("headline"));
		date.setText(rs.getString("text"));
		
		return date;
	}
}
