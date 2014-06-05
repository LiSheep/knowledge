package com.knowledge.timeline;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;

public class TimelineAssetDao extends KnowledgeDao<TimelineAsset> {

	@Override
	public int create(TimelineAsset t) {
		StringBuffer buffer = new StringBuffer("INSERT INTO knowledge_timeline_asset (id, media, credit, caption) VALUES (?, ?, ?, ?)");
		Object[] args = {t.getId(), t.getMedia(), t.getCredit(), t.getCaption()};
		
		return jdbcTemplate.update(buffer.toString(), args);
	}
	
	public TimelineAsset readOne(String id) {
		StringBuffer buffer = new StringBuffer("SELECT id, media, credit, caption FROM knowledge_timeline_asset WHERE id=?");
		Object[] args = {id};
		
		return jdbcTemplate.queryForObject(buffer.toString(), new TimelineAssetRowMapper(), args);
	}

	@Override
	public int deleteEntity(TimelineAsset t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEntity(TimelineAsset t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TimelineAsset readEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
}

class TimelineAssetRowMapper implements RowMapper<TimelineAsset> {

	@Override
	public TimelineAsset mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimelineAsset asset = new TimelineAsset();
		
		asset = new TimelineAsset();
		asset.setCaption(rs.getString("caption"));
		asset.setCredit(rs.getString("credit"));
		asset.setId(rs.getString("id"));
		asset.setMedia(rs.getString("media"));
		
		return asset;
	}
}
