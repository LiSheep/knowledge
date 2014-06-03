package com.knowledge.timeline;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.common.DataConvUtil;

public class TimelineDao extends KnowledgeDao<Timeline> {

	@Override
	public int create(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Timeline readByUser(String userKey) {
		StringBuffer buffer = new StringBuffer("SELECT id, text, headline, startDate, type FROM knowledge_timeline_headline WHERE userKey=?");
		Object[] args = {userKey};
		return jdbcTemplate.queryForObject(buffer.toString(), new TimelineRowMapper(), args);
	}

	@Override
	public int deleteEntity(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntity(Timeline t) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class TimelineRowMapper implements RowMapper<Timeline> {

	@Override
	public Timeline mapRow(ResultSet rs, int rowNum) throws SQLException {
		Timeline timeline = new Timeline();
		
		timeline.setId(rs.getString("id"));
		timeline.setHeadline(rs.getString("headline"));
		timeline.setType(rs.getString("type"));
		timeline.setText(rs.getString("text"));
		timeline.setStartDate(DataConvUtil.dateFormatJson(rs.getDate("startDate")));
		
		return timeline;
	}
	
}