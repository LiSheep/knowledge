package com.knowledge.dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Dictionary read(Dictionary t, KnowledgeRowMapper<Dictionary> mapper) {
		
		return null;
	}
	
	public Dictionary readFieldNameByCode(int code) {
		StringBuffer buffer = new StringBuffer("SELECT  id, fieldName, fieldCode, `code`, label FROM knowledge_dictionary WHERE fieldCode = ? GROUP BY fieldCode");
		Object[] args = {code};
		return jdbcTemplate.query(buffer.toString(), args, new DictionaryMapper());
		
	}
	
	//query more Objects from dictionary where select by fieldCode
	public List<Dictionary> readLabels(int fieldCode) {
		StringBuffer buffer = new StringBuffer("SELECT  id, fieldName, fieldCode, `code`, label FROM knowledge_dictionary WHERE fieldCode = ?");
		Object[] args = {fieldCode};
		
		return jdbcTemplate.query(buffer.toString(), new DictionaryMapperList(), args);
	}
}

//map a row to a Dictionary, and return one Dictionary Object
class DictionaryMapper implements ResultSetExtractor<Dictionary> {

	@Override
	public Dictionary extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Dictionary dictionary = new Dictionary();
		
		dictionary.setCode(rs.getInt("code"));
		dictionary.setFieldCode(rs.getInt("fieldCode"));
		dictionary.setFieldName(rs.getString("fieldName"));
		dictionary.setLabel(rs.getString("label"));
		
		return dictionary;
	}	
}

//map a row to a Dictionary, and return one Dictionary List
class DictionaryMapperList implements RowMapper<Dictionary> {
	@Override
	public Dictionary mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dictionary dictionary = new Dictionary();
		
		dictionary.setCode(rs.getInt("code"));
		dictionary.setFieldCode(rs.getInt("fieldCode"));
		dictionary.setFieldName(rs.getString("fieldName"));
		dictionary.setLabel(rs.getString("label"));
		
		return dictionary;
	}
}
