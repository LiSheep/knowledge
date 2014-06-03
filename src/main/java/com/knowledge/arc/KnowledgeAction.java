package com.knowledge.arc;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class KnowledgeAction<T extends KnowledgeEntity> extends ActionSupport implements ModelDriven<T>{

	private static final long serialVersionUID = -8408713779676642460L;
	
	protected T model;
	protected List<T> entities;
	
	public List<T> getEntities(){
		if(this.entities == null){
			this.entities = new ArrayList<T>();
		}
		return this.entities;
	}
	
}
