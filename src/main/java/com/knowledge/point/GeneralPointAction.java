package com.knowledge.point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

public class GeneralPointAction extends KnowledgeAction<GeneralPoint> {

	private static final long serialVersionUID = -4973793253208227806L;
	private GeneralPointServices generalPointServices;
	private DictionaryServices dictionaryServices;

	public String input() {
		setSessions();
		if (getModel().getId() != null) // 更新界面需要填入值
			this.model = generalPointServices.findEntity(getModel());
		return "add";
	}

	// 提交更改，以有没有Id值判断是插入还是修改
	public String subinput() {
		if (getModel().getId() == null) { // 插入
			generalPointServices.add(getModel());
		} else { // 更新
			generalPointServices.update(getModel());
		}
		return "adminlist";
	}

	// 粗知识点管理列表
	public String adminList() {
		generalPointServices.list(getPage());
		return "adminlist";
	}

	// 删除粗知识点
	public String delete() {
		this.entities = null;
		generalPointServices.deleteLogic(getModel());
		return "adminlist";
	}

	public void setSessions() {
		List<Dictionary> dicImportance = null;
		List<Dictionary> dicComplexity = null;
		List<Dictionary> dicType = null;
		try {
			// dicImportance =
			// dictionaryServices.findLabels(Integer.valueOf(getText("FieldImportance.fieldCode")));
			// dicComplexity =
			// dictionaryServices.findLabels(Integer.valueOf(getText("FieldComplexity.fieldCode")));
			dicType = dictionaryServices.findLabels(2);
			dicImportance = dictionaryServices.findLabels(3);
			dicComplexity = dictionaryServices.findLabels(4);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ActionContext.getContext().getSession()
				.put("pointImportance", dicImportance);
		ActionContext.getContext().getSession()
				.put("pointComplexity", dicComplexity);
		ActionContext.getContext().getSession().put("pointType", dicType);
	}

	// get & set method
	@Override
	public GeneralPoint getModel() {
		if (this.model == null) {
			this.model = new GeneralPoint();
		}
		return this.model;
	}

	public String getLabel(String field, int code) {
		int fieldCode = 0;
		// TODO:这个要改哦
		if(field.equals("importance"))
			fieldCode = 3;
		else if(field.equals("complexity"))
			fieldCode = 4;
		Dictionary resutlDictionary = null;
		try {
			resutlDictionary =  dictionaryServices.findDictionary(fieldCode, code);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "系统错误";
		}
		return "fuck";
	}

	public GeneralPointServices getGeneralPointServices() {
		return generalPointServices;
	}

	public void setGeneralPointServices(
			GeneralPointServices generalPointServices) {
		this.generalPointServices = generalPointServices;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}

}
