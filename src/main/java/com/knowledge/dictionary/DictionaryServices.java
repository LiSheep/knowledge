package com.knowledge.dictionary;

import java.util.UUID;

import com.knowledge.arc.KnowledgeServices;

public class DictionaryServices implements KnowledgeServices<Dictionary> {
	private DictionaryDao dictionaryDao;
	
	/*
	 * 向数据字典添加一条数据(non-Javadoc)
	 * @see com.knowledge.arc.KnowledgeServices#add(com.knowledge.arc.KnowledgeEntity)
	 */
	public int add(Dictionary dictionary) {
		dictionary.setId(UUID.randomUUID().toString());
		
		return dictionaryDao.create(dictionary);
	}

	@Override
	public int remove(Dictionary t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int find(Dictionary t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
}
