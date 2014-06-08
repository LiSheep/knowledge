package com.knowledge.compute;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.knowledge.arc.KnowledgeDao;
import com.knowledge.point.GeneralPoint;

public class ComputeDao extends KnowledgeDao<Compute> {

	@Override
	public int create(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEntity(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}
	//查询所有的粗知识点的key
	public List<GeneralPoint> readAllKey() {
		String sql = "SELECT id FROM knowledge_point_general";
		
		return jdbcTemplate.query(sql, new ComputeGeneralPointRowMapper());
	}

	//更新粗知识点的complexity和importance
	@Override
	public int updateEntity(Compute t) {
		String sql ="UPDATE knowledge_point_general SET complexity = ?, importance = ? WHERE id = ?";
		Object[] args = {t.getComplexity(), t.getImportance(), t.getGeneralKey()};
		
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Compute readEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Compute readNewComplexityAndImportance(String generalKey) {
		String sql = "SELECT ceil(avg(complexity)) AS complexity, ceil(avg(importance)) AS importance FROM knowledge_point_comment WHERE generalKey = ? GROUP BY generalKey";
		Object[] args = {generalKey};
		
		return jdbcTemplate.queryForObject(sql, new ComputeRowMapper(), args);
	}
}

class ComputeRowMapper implements RowMapper<Compute> {

	@Override
	public Compute mapRow(ResultSet rs, int rowNum) throws SQLException {
		Compute compute = new Compute();
		compute.setGeneralKey(rs.getString("generalKey"));
		compute.setComplexity(rs.getInt("complexity"));
		compute.setImportance(rs.getInt("importance"));
		
		return compute;
	}
}

class ComputeGeneralPointRowMapper implements RowMapper<GeneralPoint> {

	@Override
	public GeneralPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
		GeneralPoint generalPoint = new GeneralPoint();
		generalPoint.setId(rs.getString("id"));
		
		return generalPoint;
	}
}
