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
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<TimelineDate> readByHeadlineKey(String headlineKey) {
		StringBuffer buffer = new StringBuffer("SELECT id, text, headline, startDate, type FROM knowledge_timeline_date WHERE headlineKey=?");
		Object[] args = {headlineKey};
		
		return jdbcTemplate.query(buffer.toString(), new TimelineDateRowMapper(), args);
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
}

class TimelineDateRowMapper implements RowMapper<TimelineDate> {

	@Override
	public TimelineDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimelineDate date = new TimelineDate();
		
		date.setId(rs.getString("id"));
		date.setAsset(new TimelineAssetDao().readOne(rs.getString("asset")));
		date.setEndDate(DataConvUtil.dateFormatJson(rs.getDate("endDate")));
		date.setStartDate(DataConvUtil.dateFormatJson(rs.getDate("startDate")));
		date.setHeadline(rs.getString("headline"));
		date.setText(rs.getString("text"));
		
		return date;
	}
}
