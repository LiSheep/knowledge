package com.knowledge.node;

import org.springframework.jdbc.core.JdbcTemplate;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.arc.KnowledgeRowMapper;

public class NodeDao implements KnowledgeDao<NodeCarsness> {
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(NodeCarsness t) {
		String sql = "INSERT INTO knowledge_point_carsness (id, knowName, knowType, knowOrder, knowImportance, knowComplexity, knowDescription) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Object[] args = {t.getId(), t.getKnowName(), t.getKnowType(), t.getKnowOrder(), t.getKnowImportance(), t.getKnowComplexity(), t.getKnowDescription()};
		
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int delete(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NodeCarsness read(NodeCarsness t,
			KnowledgeRowMapper<NodeCarsness> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
