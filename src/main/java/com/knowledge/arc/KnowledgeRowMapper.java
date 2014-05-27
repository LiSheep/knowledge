package com.knowledge.arc;

import java.sql.ResultSet;

import org.springframework.jdbc.core.ResultSetExtractor;

public interface KnowledgeRowMapper<T extends KnowledgeEntity> extends ResultSetExtractor<T> {
	/*
	 * 返回数据库中一条数据封装的Object
	 * @param ResultSet : 数据库查询的结果集
	 * @param num : 忽略第几行数据
	 */
	T mapRecord(ResultSet result, int num);
}
