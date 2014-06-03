package com.knowledge.dictionary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;

public class DictionaryDao extends KnowledgeDao<Dictionary>{
	
	public int create(Dictionary dictionary) {
		String sql = "INSERT INTO knowledge_dictionary (id, fieldCode, fieldName, `code`, label) VALUES (?, ?, ?, ?, ?)";
		Object[] args = {dictionary.getId(), dictionary.getFieldCode(), dictionary.getFieldName(), dictionary.getCode(), dictionary.getLabel()};
		
		return jdbcTemplate.update(sql, args);
	}
	
	public int deleteEntity(Dictionary dictionary) {
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
	
	public Dictionary readFieldNameByFieldCode(int fieldCode) {
		StringBuffer buffer = new StringBuffer("SELECT  id, fieldName, fieldCode, `code`, label FROM knowledge_dictionary WHERE fieldCode = ? AND delflag = 0 GROUP BY fieldCode");
		Object[] args = {fieldCode};
		return jdbcTemplate.queryForObject(buffer.toString(), args, new DictionaryMapper());
	}
	
	//query more Objects from dictionary where select by fieldCode
	public List<Dictionary> readLabels(int fieldCode) {
		StringBuffer buffer = new StringBuffer("SELECT  id, fieldName, fieldCode, `code`, label FROM knowledge_dictionary WHERE fieldCode = ? AND delflag = 0 ORDER BY code");
		//order by code so the dictionary's last one will be the biggest one - ltc update 29.05.2014
		Object[] args = {fieldCode};
		return jdbcTemplate.query(buffer.toString(), new DictionaryMapper(), args);
	}
	
	public Dictionary readByFieldCode_Code(int fieldCode, int code){
		String sql = "SELECT id, fieldName, fieldCode, `code`, label FROM knowledge_dictionary  where fieldCode = ? AND `code` = ? AND delflag = 0";
		Object[] args = {fieldCode, code};
		return jdbcTemplate.queryForObject(sql, new DictionaryMapper(), args);
	}

	@Override
	public int updateEntity(Dictionary t) {
		// TODO Auto-generated method stub
		return 0;
	}
}

//map a row to a Dictionary, and return one Dictionary List
class DictionaryMapper implements RowMapper<Dictionary> {
	@Override
	public Dictionary mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dictionary dictionary = new Dictionary();
		
		dictionary.setId(rs.getString("id"));
		dictionary.setCode(rs.getInt("code"));
		dictionary.setFieldCode(rs.getInt("fieldCode"));
		dictionary.setFieldName(rs.getString("fieldName"));
		dictionary.setLabel(rs.getString("label"));
		
		return dictionary;
	}
}
