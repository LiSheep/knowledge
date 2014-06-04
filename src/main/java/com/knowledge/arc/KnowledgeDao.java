package com.knowledge.arc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.knowledge.page.Page;

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
	
	//查询记录个数
	public int query4TotalCount(String sql, Object[]args) {
		String buffer = "SELECT count(1) as count FROM (" + sql + " ) AS T1";
		return jdbcTemplate.queryForInt(buffer, args);
	}
	
	//分页
	public void query4Page(String sql, RowMapper<T> mapper, Page<T> page, Object[]args, int num) {
		page.setTotalCount(query4TotalCount(sql, args));
		StringBuffer buffer = new StringBuffer(sql);
		int startCursor = page.getPageNum() * page.getPageSize();
		int endCursor = page.getPageSize();
		
		buffer.append(" ORDER BY ").append(page.getOrderBy()).append(" LIMIT ").append(startCursor).append(", ").append(endCursor);
		page.setResult(jdbcTemplate.query(buffer.toString(), mapper, args));
	}
	
	// get & set method
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
