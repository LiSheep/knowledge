package com.knowledge.point;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.dictionary.DictionaryServices;
import com.knowledge.page.Page;

public class GeneralPointServices  implements KnowledgeServices<GeneralPoint> {

	private GeneralPointDao generalPointDao;
	DictionaryServices dictionaryServices;
	
	@Override
	public int add(GeneralPoint t) {
		int maxImportanceCode = 0, maxComplexityCode = 0, maxPointType = -1;
		try {
			maxPointType = dictionaryServices.findMaxCodeByFieldCode(2);
			maxImportanceCode = dictionaryServices.findMaxCodeByFieldCode(3);
			maxComplexityCode = dictionaryServices.findMaxCodeByFieldCode(4);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (t.getPointName() == null || t.getPointType() <= 0
				|| t.getPointType() > maxPointType
				|| t.getImportance() <= 0
				|| t.getImportance() > maxImportanceCode
				|| t.getComplexity() <= 0
				|| t.getComplexity() > maxComplexityCode || t.getOrderNum() < 0) {
			return 0;
		}
		t.setId(UUID.randomUUID().toString());
		
		return generalPointDao.create(t);
	}

	@Override
	public int remove(GeneralPoint t) {
		return generalPointDao.deleteEntity(t);
	}

	@Override
	public GeneralPoint findEntity(GeneralPoint t) {
		
		return null;
	}
	
	@Override
	public int update(GeneralPoint t) {
		return generalPointDao.updateEntity(t);
	}

	@Override
	public int deleteLogic(GeneralPoint t) {
		return generalPointDao.deleteLogic(t);
	}
	
	@Override
	public GeneralPoint findEntityById(Object id) {
		return generalPointDao.readEntityById(id);
	}
	
	@Override
	public List<GeneralPoint> list(Page<GeneralPoint> page) {
		generalPointDao.list(page);
		return null;
		//TODO:不需要返回值，在框架里GetEntities直接返回page.getResult().但是，如果需要不分页的list则 不能用entities。
		//具体请看KnowledgeAction的getEntities -ltc 01.06.2014
	}

	
	// get & set method
	public GeneralPointDao getGeneralPointDao() {
		return generalPointDao;
	}

	public void setGeneralPointDao(GeneralPointDao generalPointDao) {
		this.generalPointDao = generalPointDao;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}

}
