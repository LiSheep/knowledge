package com.knowledge.point;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.knowledge.arc.KnowledgeDao;

public class GeneralPointDao extends KnowledgeDao<GeneralPoint> {

	@Override
	public int create(GeneralPoint t) {
		String sql = "INSERT INTO knowledge_point_general(id, pointName, pointType, orderNum, complexity, importance) VALUES (?, ?, ?, ?, ?, ?)";
		Object[] args = { t.getId(), t.getPointName(), t.getPointType(),
				t.getOrderNum(), t.getComplexity(), t.getImportance() };
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteEntity(GeneralPoint t) {
		String sql = "DELETE FROM knowledge_point_general WHERE id = ?";
		return jdbcTemplate.update(sql, t.getId());
	}

	@Override
	public int updateEntity(GeneralPoint t) {
		String sql = "UPDATE  knowledge_point_general SET pointName=?, pointType=?, orderNum=?, importance=?, complexity=? WHERE id=?";
		Object[] args = { t.getPointName(), t.getPointType(), t.getOrderNum(),
				t.getImportance(), t.getComplexity(), t.getId() };
		return jdbcTemplate.update(sql, args);
	}

	// get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// row mapper
	class CommentMapper implements ResultSetExtractor<GeneralPoint> {

		@Override
		public GeneralPoint extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			GeneralPoint model = new GeneralPoint();
			model.setId(rs.getString("id"));
			model.setPointName(rs.getString("pointName"));
			model.setPointType(rs.getInt("pointType"));
			model.setOrderNum(rs.getInt("orderNum"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));
			return model;
		}

	}
}
