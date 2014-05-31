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
			.newBuilder().maximumSize(1000)
			.build(new CacheLoader<String, List<Dictionary>>() {

				@Override
				public List<Dictionary> load(String key) throws Exception {
					return dictionaryDao.readLabels(Integer.valueOf(key));
				}
			});

	// 通过fieldCode, code 读取dictionary
	private LoadingCache<Dictionary, Dictionary> cacheKVBuilder = CacheBuilder
			.newBuilder().maximumSize(1000)
			.build(new CacheLoader<Dictionary, Dictionary>() {

				@Override
				public Dictionary load(Dictionary key) throws Exception {
					int fieldCode = key.getFieldCode();
					int code = key.getCode();
					return dictionaryDao.readByFieldCode_Code(fieldCode, code);
				}
			});

	/*
	 * 向数据字典添加一条数据(non-Javadoc)
	 * 
	 * @see
	 * com.knowledge.arc.KnowledgeServices#add(com.knowledge.arc.KnowledgeEntity
	 * )
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
	public Dictionary findEntity(Dictionary t) {
		// TODO Auto-generated method stub
		return null;
	}

	// get the labels by fieldCode
	public List<Dictionary> findLabels(int fieldCode) throws ExecutionException {
		List<Dictionary> retDictionaries = cahceBuilder.get(String
				.valueOf(fieldCode));
		return retDictionaries;
	}

	// 通过fieldCode, code 读取dictionary
	public Dictionary findDictionary(int fieldCode, int code)
			throws ExecutionException {
		Dictionary dictionary = new Dictionary();
		dictionary.setFieldCode(fieldCode);
		dictionary.setCode(code);
		return cacheKVBuilder.get(dictionary);
	}

	public int findMaxCodeByFieldCode(int fieldCode) throws ExecutionException{
		List<Dictionary> result = this.findLabels(fieldCode);
		 return result.get(result.size() - 1).getCode();
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	@Override
	public int update(Dictionary t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete_logic(Dictionary t, String tableName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
