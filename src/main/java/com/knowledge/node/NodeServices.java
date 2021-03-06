package com.knowledge.node;

import java.util.List;
import java.util.UUID;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.page.Page;

public class NodeServices implements KnowledgeServices<NodeCarsness> {
	private NodeDao nodeDao;
	
	@Override
	public int add(NodeCarsness t) {
		t.setId(UUID.randomUUID().toString());
		
		return nodeDao.create(t);
	}

	@Override
	public int remove(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}


	public NodeDao getNodeDao() {
		return nodeDao;
	}

	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}

	@Override
	public NodeCarsness findEntity(NodeCarsness t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NodeCarsness findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NodeCarsness> list(Page<NodeCarsness> page) {
		// TODO Auto-generated method stub
		return null;
	}
}
