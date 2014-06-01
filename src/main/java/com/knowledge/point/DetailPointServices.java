package com.knowledge.point;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.dictionary.DictionaryServices;
import com.knowledge.page.Page;

public class DetailPointServices implements KnowledgeServices<DetailPoint> {

	private DetailPointDao detailPointDao;
	private DictionaryServices dictionaryServices;

	@Override
	public int add(DetailPoint t) {
		int maxImportanceCode = 0, maxComplexityCode = 0;
		//TODO:这里要改哦
		try {
			maxImportanceCode = dictionaryServices.findMaxCodeByFieldCode(3);
			maxComplexityCode = dictionaryServices.findMaxCodeByFieldCode(4);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (t.getPointName() == null || t.getImportance() <= 0
				|| t.getImportance() > maxImportanceCode
				|| t.getComplexity() <= 0
				|| t.getComplexity() > maxComplexityCode
				|| t.getGeneralKey() == null) {
			return 0;
		}
		t.setId(UUID.randomUUID().toString());

		return detailPointDao.create(t);
	}

	@Override
	public int remove(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DetailPoint findEntity(DetailPoint t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteLogic(DetailPoint t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public DetailPoint findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<DetailPoint> list(Page<DetailPoint> page) {
		// TODO Auto-generated method stub
		return null;
	}

	// get & set method
	public DetailPointDao getDetailPointDao() {
		return detailPointDao;
	}

	public void setDetailPointDao(DetailPointDao detailPointDao) {
		this.detailPointDao = detailPointDao;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}

}
