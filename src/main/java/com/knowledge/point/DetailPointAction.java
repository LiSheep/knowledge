package com.knowledge.point;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

public class DetailPointAction extends KnowledgeAction<DetailPoint>{

	private static final long serialVersionUID = 8423136847466976304L;
	private DetailPointServices detailPointServices;
	private DictionaryServices dictionaryServices;
	
	@Override
	public DetailPoint getModel() {
		if(model == null){
			model = new DetailPoint();
		}
		return model;
	}

	public String input(){
		setSessions();
		return "add";
	}

	public String add(){
		setSessions();
		getModel().setGeneralKey("b493e7b8-8368-42df-8850-50dfe36edffe");
		detailPointServices.add(getModel());
		return "add";
	}
	public void setSessions() {
		List<Dictionary> dicImportance = null;
		List<Dictionary> dicComplexity = null;
		try {
//			dicImportance = dictionaryServices.findLabels(Integer.valueOf(getText("FieldImportance.fieldCode")));
//			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(getText("FieldComplexity.fieldCode")));
			dicImportance = dictionaryServices.findLabels(Integer.valueOf(3));
			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(4));
			//TODO:这里要改哦
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionContext.getContext().getSession().put("pointImportance", dicImportance);
		ActionContext.getContext().getSession().put("pointComplexity", dicComplexity);
	}
	
	//get & set method
	public DetailPointServices getDetailPointServices() {
		return detailPointServices;
	}

	public void setDetailPointServices(DetailPointServices detailPointServices) {
		this.detailPointServices = detailPointServices;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
}
