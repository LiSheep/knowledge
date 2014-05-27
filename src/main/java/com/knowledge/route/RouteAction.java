package com.knowledge.route;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RouteAction extends ActionSupport {

	/**
	 * route the a request to destination
	 */
	private static final long serialVersionUID = -3285421415589560598L;
	private DictionaryServices dictionaryServices;
	
	public String dicManage() {
		
		return "dic";
	}
	public String node() {
		
		return SUCCESS;
	}
	
	/*
	 * go to knowledge node add page
	 * 
	 * dicType : 知识点类型
	 * dicImportance : 知识点重要程度
	 * dicComplexity : 知识点难以程度
	 */
	public String nodeAdd() throws NumberFormatException, ExecutionException {
		List<Dictionary> dicType = dictionaryServices.findLabels(Integer.valueOf(getText("FieldType.fieldCode")));
		List<Dictionary> dicImportance = dictionaryServices.findLabels(Integer.valueOf(getText("FieldImportance.fieldCode")));
		List<Dictionary> dicComplexity = dictionaryServices.findLabels(Integer.valueOf(getText("FieldComplexity.fieldCode")));
		
		ActionContext.getContext().getSession().put("nodeType", dicType);
		ActionContext.getContext().getSession().put("nodeImportance", dicImportance);
		ActionContext.getContext().getSession().put("nodeComplexity", dicComplexity);
		
		return "add";
	}
	
	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}
	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
}
