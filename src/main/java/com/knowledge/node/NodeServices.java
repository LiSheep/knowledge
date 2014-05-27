package com.knowledge.node;

import java.util.UUID;

import com.knowledge.arc.KnowledgeServices;

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

	@Override
	public int find(NodeCarsness t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public NodeDao getNodeDao() {
		return nodeDao;
	}

	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
}
