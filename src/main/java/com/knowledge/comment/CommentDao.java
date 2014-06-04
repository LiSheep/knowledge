package com.knowledge.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.page.Page;
import com.knowledge.user.User;

public class CommentDao extends KnowledgeDao<Comment> {

	@Override
	public int create(Comment t) {
		String sql = "INSERT INTO knowledge_point_comment(id, complexity, importance, comment, note) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		Object[] args = { t.getId(), t.getComplexity(), t.getImportance(), t.getComment(), t.getNote()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteEntity(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateEntity(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Comment readEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Comment> listByGeneralPointId(Page<Comment> page, Object gId) {
		String sql = "SELECT co.id AS uid, co.complexity, co.importance,co.`comment`, co.note, co.updateTime, u.id AS userKey, u.username, g.id AS gId FROM knowledge_point_comment AS co, knowledge_user AS u, knowledge_point_general AS g WHERE u.delflag = 0 AND g.delflag = 0 AND g.Id = ? AND co.generalKey = g.id AND u.id = co.userKey";
		Object []args = {gId };
		this.query4Page(sql, new CommentMapper(), page, args, 0);
		return page.getResult();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class CommentMapper implements RowMapper<Comment> {
		@Override
		public Comment mapRow(ResultSet rs, int num) throws SQLException {
			Comment model = new Comment();
			model.setId(rs.getString("uid"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));
			model.setComment(rs.getString("comment"));
			model.setNote(rs.getString("note"));
			model.setUpdateTime(rs.getTimestamp("updateTime"));

			// user
			model.getUser().setId(rs.getString("userKey"));
			model.getUser().setUsername(rs.getString("username"));
			
			//general point
			model.getGeneralPoint().setId(rs.getString("gId"));
			return model;
		}
	}

}
