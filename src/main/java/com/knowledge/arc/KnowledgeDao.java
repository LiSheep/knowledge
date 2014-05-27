package com.knowledge.arc;

/*
 * 构建dao接口,提供基本的add, delete, read方法
 * @param T : KnowledgeEntity对象,表示dao是对什么对象操作,完成对象的依赖注入
 */
public interface KnowledgeDao<T extends KnowledgeEntity> {
	
	int create(T t);
	int delete(T t);
	/*
	 * query one Object
	 * @param mapper : Object rowmapper
	 */
	T read(T t, KnowledgeRowMapper<T> mapper);
}
