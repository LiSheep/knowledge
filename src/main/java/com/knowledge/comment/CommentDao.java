package com.knowledge.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javassist.expr.NewArray;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.page.Page;
import com.knowledge.point.GeneralPoint;

public class CommentDao extends KnowledgeDao<Comment> {

	@Override
	public int create(Comment t) {
		String sql = "INSERT INTO knowledge_point_comment(id, generalKey, detailKey, userKey, complexity, importance, comment, note) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = { t.getId(), t.getGeneralPoint().getId(), t.getDetailPoint().getId(), t.getUser().getId(), t.getComplexity(), t.getImportance(), t.getComment(), t.getNote()};
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
	
	public int updateNote(Comment t){
		String sql = "UPDATE " + t.getTableName() + " SET note = ?, updateTime = CURRENT_TIMESTAMP  WHERE id = ?";
		Object []args = {t.getNote(), t.getId() };
		return this.jdbcTemplate.update(sql, args);
	}
	
	public int updateComment(Comment t){
		String sql = "UPDATE " + t.getTableName() + " SET `comment` = ?, updateTime = CURRENT_TIMESTAMP WHERE id = ? ";
		Object []args = {t.getComment(), t.getId() };
		return this.jdbcTemplate.update(sql, args);
	}
	
	/*
	 * @author ltc
	 * @Param GeneralPoint id
	 * @Param User id
	 * @return comment entity
	 * 
	 * 通过知识体系查看该知识体系下的所有知识点
	 */
	public Comment readEntityByGPointIdAndUserId(Object gid, Object uid){
		String sql = "SELECT co.id AS coid, co.complexity, co.importance,co.`comment`, co.note, co.updateTime, u.id AS userKey, u.username, g.id AS gId, g.pointName, g.pointType FROM knowledge_point_general AS g LEFT JOIN knowledge_point_comment AS co ON g.id = co.generalKey LEFT JOIN knowledge_user AS u ON co.userKey = u.id AND (u.id =? OR u.id = NULL) WHERE g.id = ? AND g.delflag = 0";
		Object []args = {uid, gid };
		Comment entity = null;
		try {
			entity = jdbcTemplate.queryForObject(sql, new CommentMapperWithGPoint(), args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		return entity;
	}

	public List<Comment> listByGeneralPointId(Page<Comment> page, Object gId) {
		String sql = "SELECT co.id AS coid, co.complexity, co.importance,co.`comment`, co.note, co.updateTime, u.id AS userKey, u.username, g.id AS gId FROM knowledge_point_comment AS co, knowledge_user AS u, knowledge_point_general AS g WHERE u.delflag = 0 AND g.delflag = 0 AND g.Id = ? AND co.generalKey = g.id AND u.id = co.userKey AND co.`comment` != NULL";
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
			model.setId(rs.getString("coid"));
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
	
	class CommentMapperWithGPoint implements RowMapper<Comment> {
		@Override
		public Comment mapRow(ResultSet rs, int num) throws SQLException {
			Comment model = new Comment();
			model.setId(rs.getString("coid"));
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
			model.getGeneralPoint().setPointName(rs.getString("pointName"));
			model.getGeneralPoint().setPointType(rs.getInt("pointType"));
			return model;
		}
	}

}
