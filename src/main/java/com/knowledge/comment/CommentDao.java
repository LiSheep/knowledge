package com.knowledge.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.arc.KnowledgeRowMapper;
import com.knowledge.dictionary.Dictionary;

public class CommentDao implements KnowledgeDao<Comment> {

	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment read(Comment t, KnowledgeRowMapper<Comment> mapper) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Comment> list(){
		System.out.println("exe query...");
		return null;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	class CommentMapper implements ResultSetExtractor<Comment>{
		@Override
		public Comment extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Comment model = new Comment();
			model.setId(rs.getString("id"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));
			model.setComment(rs.getString("comment"));
			model.setSuggestion(rs.getString("suggestion"));
			return model;
		}
	}
	class CommentMapperList implements RowMapper<Comment> {
		@Override
		public Comment mapRow(ResultSet rs, int num) throws SQLException {
			Comment model = new Comment();
			model.setId(rs.getString("id"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));
			model.setComment(rs.getString("comment"));
			model.setSuggestion(rs.getString("suggestion"));
			return model;
		}
	}
}
