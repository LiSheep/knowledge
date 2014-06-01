package com.knowledge.node;

import org.springframework.jdbc.core.JdbcTemplate;

import com.knowledge.arc.KnowledgeDao;

public class NodeDao extends KnowledgeDao<NodeCarsness> {
	@Override
	public int create(NodeCarsness t) {
		String sql = "INSERT INTO knowledge_point_carsness (id, knowName, knowType, knowOrder, knowImportance, knowComplexity, knowDescription) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Object[] args = {t.getId(), t.getKnowName(), t.getKnowType(), t.getKnowOrder(), t.getKnowImportance(), t.getKnowComplexity(), t.getKnowDescription()};
		
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteEntity(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int updateEntity(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
