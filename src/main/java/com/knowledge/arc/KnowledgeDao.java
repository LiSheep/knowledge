package com.knowledge.arc;

import org.springframework.jdbc.core.JdbcTemplate;

/*
 * 构建dao接口,提供基本的add, delete, read方法
 * @param T : KnowledgeEntity对象,表示dao是对什么对象操作,完成对象的依赖注入
 */
public abstract class KnowledgeDao<T extends KnowledgeEntity> {
	
	protected JdbcTemplate jdbcTemplate;
	
	public abstract int create(T t);
	public abstract int deleteEntity(T t);
	public abstract int updateEntity(T t);
	//TODO readEntity(User t)
	/*
	 * query one Object
	 * @param mapper : Object rowmapper
	 */
	
	public int deleteLogic(T t){
		String sql = "UPDATE " + t.getTableName() + " SET delflag = 1 WHERE id = ?";
		return jdbcTemplate.update(sql, t.getId());
	}
	
	// get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
