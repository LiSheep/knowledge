package com.knowledge.point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.page.Page;

public class DetailPointDao extends KnowledgeDao<DetailPoint> {

	@Override
	public int create(DetailPoint t) {
		String sql = "INSERT INTO knowledge_point_detail(id, pointName, importance, complexity, generalKey) VALUES(?, ?, ?, ?, ?)";
		Object[] args = { t.getId(), t.getPointName(), t.getImportance(),
				t.getComplexity(), t.getGeneralPoint().getId() };
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteEntity(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DetailPoint readEntityById(Object id) {
		String sql = "SELECT d.id AS dId, d.pointName AS dPointName, d.complexity, d.importance, g.id AS gId, g.pointName AS gPointName FROM knowledge_point_detail AS d, knowledge_point_general AS g WHERE g.id = d.generalKey AND d.delflag = 0 AND g.delflag = 0 AND d.id = ?";
		return jdbcTemplate.queryForObject(sql, new DetailPointRowMapperOnlyGeneralName(), id);
	}
	
	@Override
	public int updateEntity(DetailPoint t) {
		String sql = "UPDATE " + t.getTableName() + " SET pointName = ?, importance = ?, complexity = ? WHERE id = ?";
		Object []args = {t.getPointName(), t.getImportance(), t.complexity, t.getId() };
		return jdbcTemplate.update(sql, args);
	}

	public List<DetailPoint> readEntitiesByGeneralPointId(Page<DetailPoint> page, Object generalPointId) {
		String sql = "SELECT d.id AS dId, d.pointName AS dPointName, d.importance, d.complexity, d.generalKey AS gId, g.pointName AS gPointName FROM knowledge_point_detail AS d , knowledge_point_general AS g WHERE g.id = ? AND d.delflag = 0 AND g.delflag = 0 AND d.generalKey = g.id ";
		Object []args = { generalPointId }; 
		this.query4Page(sql, new DetailPointRowMapperOnlyGeneralName(), page, args, 0);
		return page.getResult();
	}
	
	public List<DetailPoint> readEntitiesByGeneralPointId(Object generalPointId){
		String sql = "SELECT d.id AS dId, d.pointName AS dPointName, d.importance, d.complexity, d.generalKey AS gId, g.pointName AS gPointName FROM knowledge_point_detail AS d , knowledge_point_general AS g WHERE g.id = ? AND d.delflag = 0 AND g.delflag = 0 AND d.generalKey = g.id ";
		Object []args = { generalPointId }; 
		return jdbcTemplate.query(sql, new DetailPointRowMapperOnlyGeneralName(), args);
	}

	// get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class DetailPointRowMapperOnlyGeneralName implements RowMapper<DetailPoint> {

		@Override
		public DetailPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
			DetailPoint model = new DetailPoint();
			model.setId(rs.getString("dId"));
			model.setPointName(rs.getString("dPointName"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));

//			model.setGeneralKey(rs.getString("gId"));
			model.getGeneralPoint().setId(rs.getString("gId"));
			model.getGeneralPoint().setPointName(rs.getString("gPointName"));
			return model;
		}
	}
}
