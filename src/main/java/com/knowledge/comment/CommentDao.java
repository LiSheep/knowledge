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
import com.knowledge.user.User;

public class CommentDao implements KnowledgeDao<Comment> {

	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Comment t) {
		String sql = "INSERT INTO knowledge_point_comment(id, complexity, importance, comment) "
				+ "VALUES(?, ?, ?, ?)";
		Object []args = {t.getId(), t.getComplexity(), t.getImportance(), t.getComment()};
		return jdbcTemplate.update(sql, args);
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
		String sql = "SELECT co.id AS id, co.complexity, co.importance,co.`comment`, co.note, co.updateTime, u.id AS userKey, u.username "
				+ "FROM knowledge_point_comment AS co, knowledge_user AS u WHERE u.id = co.userKey AND u.delflag != 1";
		return jdbcTemplate.query(sql, new CommentMapperList());
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
			model.setNote(rs.getString("note"));
			model.setUpdateTime(rs.getDate("updateTime"));
			
			//user
			User user = new User();
			user.setId(rs.getString("userKey"));
			user.setUsername(rs.getString("username"));
			
			model.setUser(user);
			
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
			model.setNote(rs.getString("note"));
			model.setUpdateTime(rs.getDate("updateTime"));
			
			//user
			User user = new User();
			user.setId(rs.getString("userKey"));
			user.setUsername(rs.getString("username"));
			
			model.setUser(user);
			return model;
		}
	}
}
