package com.knowledge.arc;

/*
 * 构建services接口,提供基本的add, remove, find方法
 * @param T : KnowledgeEntity对象,表示services是对什么对象操作,完成对象的依赖注入
 */
public interface KnowledgeServices<T extends KnowledgeEntity> {
	int add(T t);
	int remove(T t);
	T findEntity(T t);
	int update(T t);
	int delete_logic(T t, String tableName);
	
	//表示添加一条数据成功
	static final int ADDCOUNT = 1;
}
