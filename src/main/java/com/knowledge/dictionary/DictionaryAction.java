package com.knowledge.dictionary;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictionaryAction extends ActionSupport implements ModelDriven<Dictionary> {

	/**
	 * 数据字典管理相关的action
	 */
	private static final long serialVersionUID = 6559445300346209205L;
	private DictionaryServices dictionaryServices;
	/*
	 * 前台的model.fieldName中的model就是与下面的model对应的
	 */
	private Dictionary model;
	
	public String add() throws UnsupportedEncodingException {
		int tmp = dictionaryServices.add(getModel());
		
		if (1 != tmp) {
			return "redirect";
		} else {
			return SUCCESS;
		}
	}

	@Override
	public Dictionary getModel() {
		if (null == model) {
			model = new Dictionary();
		}
		return model;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
}
