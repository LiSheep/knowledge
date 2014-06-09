package com.knowledge.compute;

import java.util.List;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.page.Page;
import com.knowledge.point.GeneralPoint;

public class ComputeServices implements KnowledgeServices<Compute> {

	@Override
	public int add(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Compute> list(Page<Compute> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compute findEntity(Compute t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compute findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(Compute t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void compute() {
		List<GeneralPoint> generalPoints = computeDao.readAllKey();
		
		for (GeneralPoint generalPoint : generalPoints) {
			Compute compute = computeDao.readNewComplexityAndImportance(generalPoint.getId());
			if ( null == compute)
				continue;
			else
				computeDao.updateEntity(compute);
		}
	}
	
	private ComputeDao computeDao;

	public ComputeDao getComputeDao() {
		return computeDao;
	}

	public void setComputeDao(ComputeDao computeDao) {
		this.computeDao = computeDao;
	}
}
