package com.knowledge.json;

import com.knowledge.arc.KnowledgeEntity;

public class Charts extends KnowledgeEntity {
	private String x;
	private int y;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}
}
