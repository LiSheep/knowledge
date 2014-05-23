package com.knowledge.dictionary;

import org.springframework.jdbc.core.JdbcTemplate;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.arc.KnowledgeRowMapper;

public class DictionaryDao implements KnowledgeDao<Dictionary>{
	JdbcTemplate jdbcTemplate;
	
	public int create(Dictionary dictionary) {
		String sql = "INSERT INTO knowledge_dictionary (id, fieldCode, fieldName, `code`, label) VALUES (?, ?, ?, ?, ?)";
		Object[] args = {dictionary.getId(), dictionary.getFieldCode(), dictionary.getFieldName(), dictionary.getCode(), dictionary.getLabel()};
		
		return jdbcTemplate.update(sql, args);
	}
	
	public int delete(Dictionary dictionary) {
		String sql = "DELETE FROM knowledge_dictionary WHERE id = ?";
		Object[] args = {dictionary.getId()};
		
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Dictionary read(Dictionary t, KnowledgeRowMapper<Dictionary> mapper) {
		
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
