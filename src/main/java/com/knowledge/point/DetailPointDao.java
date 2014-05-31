package com.knowledge.point;

import org.springframework.jdbc.core.JdbcTemplate;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.arc.KnowledgeRowMapper;

public class DetailPointDao extends KnowledgeDao<DetailPoint> {
	
	@Override
	public int create(DetailPoint t) {
		String sql = "INSERT INTO knowledge_point_detail(id, pointName, importance, complexity, generalKey) VALUES(?, ?, ?, ?, ?)";
		Object []args = {t.getId(), t.getPointName(), t.getImportance(), t.getComplexity(), t.getGeneralKey()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteEntity(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DetailPoint readEntity(DetailPoint t,
			KnowledgeRowMapper<DetailPoint> mapper) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateEntity(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}

	//get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
