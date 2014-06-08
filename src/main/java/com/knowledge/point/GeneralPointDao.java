package com.knowledge.point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.json.Charts;
import com.knowledge.page.Page;

public class GeneralPointDao extends KnowledgeDao<GeneralPoint> {

	@Override
	public int create(GeneralPoint t) {
		String sql = "INSERT INTO knowledge_point_general(id, pointName, pointDescrible, pointDetail,  pointType, orderNum, complexity, importance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] args = { t.getId(), t.getPointName(), t.getPointDescrible(), t.getPointDetail(), t.getPointType(),
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
		String sql = "UPDATE "+ t.getTableName() +" SET pointName=?, pointDescrible=?, pointDetail=?, pointType=?, orderNum=?, importance=?, complexity=? WHERE id=? ";
		Object[] args = { t.getPointName(), t.getPointDescrible(), t.getPointDetail(), t.getPointType(), t.getOrderNum(),
				t.getImportance(), t.getComplexity(), t.getId() };
		return jdbcTemplate.update(sql, args);
	}
	
	public void list(Page<GeneralPoint> page){
		String sql = "SELECT id, pointName, pointDescrible, pointDetail, pointType, orderNum, complexity, importance from knowledge_point_general WHERE delflag = 0";
		page.setOrderBy("orderNum");
		this.query4Page(sql, new GeneralPointMapper(), page, null, 0);
	}
	
	public GeneralPoint readEntityById(Object id){
		String sql = "SELECT id, pointName, pointDescrible, pointDetail, pointType, complexity, importance, orderNum FROM knowledge_point_general WHERE id=? AND delflag = 0";
		GeneralPoint entity = null;
		try {
			entity = jdbcTemplate.queryForObject(sql, new GeneralPointMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return entity;
	}
	
	/*
	 * @author LiuNaidi
	 * @Param General Point Type
	 * @return all the General Points of type
	 * 
	 * 通过知识体系查看该知识体系下的所有知识点
	 */
	public List<GeneralPoint> readEntityByType(Object type) {
		String sql = "SELECT id, pointName, pointDescrible, pointDetail, pointType, orderNum, importance, complexity FROM knowledge_point_general WHERE pointType= ?";
		Object[] args = {type};
		
		return jdbcTemplate.query(sql, new GeneralPointMapper(), args);
	}

	// get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// row mapper
	class GeneralPointMapper implements RowMapper<GeneralPoint> {

		@Override
		public GeneralPoint mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			
			GeneralPoint model = new GeneralPoint();
			model.setId(rs.getString("id"));
			model.setPointName(rs.getString("pointName"));
			model.setPointDescrible(rs.getString("pointDescrible"));
			model.setPointDetail(rs.getString("pointDetail"));
			model.setPointType(rs.getInt("pointType"));
			model.setOrderNum(rs.getInt("orderNum"));
			model.setComplexity(rs.getInt("complexity"));
			model.setImportance(rs.getInt("importance"));
			return model;
		}
	}

	public List<Charts> readJsonByComplexityType(Object type) {
		String sql = "SELECT id, pointName, orderNum, importance, complexity FROM knowledge_point_general WHERE pointType= ?";
		Object[] args = {type};
		
		return jdbcTemplate.query(sql, new GeneralPointJsonComplexityMapper(), args);
	}
	public List<Charts> readJsonByImportanceType(Object type) {
		String sql = "SELECT id, pointName, orderNum, importance, complexity FROM knowledge_point_general WHERE pointType= ?";
		Object[] args = {type};
		
		return jdbcTemplate.query(sql, new GeneralPointJsonImportanceMapper(), args);
	}
}

class GeneralPointJsonComplexityMapper implements RowMapper<Charts> {

	@Override
	public Charts mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		Charts model = new Charts();
		model.setId(rs.getString("id"));
		model.setX(rs.getInt("orderNum") + "." + rs.getString("pointName"));
		//Y轴的大小为重要程度+难易程度
		model.setY(rs.getInt("complexity"));
		return model;
	}
}
class GeneralPointJsonImportanceMapper implements RowMapper<Charts> {

	@Override
	public Charts mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		Charts model = new Charts();
		model.setId(rs.getString("id"));
		model.setX(rs.getInt("orderNum") + "." + rs.getString("pointName"));
		//Y轴的大小为重要程度+难易程度
		model.setY(rs.getInt("importance"));
		return model;
	}
}
