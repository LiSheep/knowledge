package com.knowledge.arc;


import java.util.List;

import com.knowledge.page.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class KnowledgeAction<T extends KnowledgeEntity> extends ActionSupport implements ModelDriven<T>{

	private static final long serialVersionUID = -8408713779676642460L;
	
	protected T model;
	protected List<T> entities;
	protected Page<T> page;
	
	protected String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<T> getEntities(){
		this.entities = getPage().getResult();
		return this.entities;
	}

	public Page<T> getPage() {
		if(page == null){
			page = new Page<T>();
		}
		return page;
	}
}
