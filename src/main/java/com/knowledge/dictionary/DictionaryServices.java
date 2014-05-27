package com.knowledge.dictionary;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.knowledge.arc.KnowledgeServices;

public class DictionaryServices implements KnowledgeServices<Dictionary> {
	private DictionaryDao dictionaryDao;
	private LoadingCache<String, List<Dictionary>> cahceBuilder = CacheBuilder
	        .newBuilder()
	        .maximumSize(1000)
	        .build(new CacheLoader<String, List<Dictionary>>(){

				@Override
				public List<Dictionary> load(String key) throws Exception {
					return dictionaryDao.readLabels(Integer.valueOf(key));
				}
	        }); 
	
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
	
	//get the labels by fieldCode
	public List<Dictionary> findLabels(int fieldCode) throws ExecutionException {
		
		return cahceBuilder.get(String.valueOf(fieldCode));
	}

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
}
