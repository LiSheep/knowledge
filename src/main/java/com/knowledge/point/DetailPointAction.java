package com.knowledge.point;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

/*
 * DetailPoint Action
 * ltc 2014/06/08
 */
public class DetailPointAction extends KnowledgeAction<DetailPoint>{

	private static final long serialVersionUID = 8423136847466976304L;
	private DetailPointServices detailPointServices;
	private GeneralPointServices generalPointServices;
	private DictionaryServices dictionaryServices;
	
	@Override
	public DetailPoint getModel() {
		if(model == null){
			model = new DetailPoint();
		}
		return model;
	}
	
	public String addInput(){
		setSessions();
		String generalId = getKey();
		GeneralPoint generalPoint = generalPointServices.findEntityById(generalId);
		if(generalPoint == null)
			return "tolist";	//增加未获取到general point
		this.model.setGeneralPoint(generalPoint);
		return "toinput";
	}
	
	public String updateInput(){
		setSessions();
		String detailId = getKey();
		if ( detailId != null && !detailId.equals("")){ // 更新界面需要的值
			DetailPoint detailPoint = detailPointServices.findEntityById(detailId);
			if(detailPoint != null){
				this.model = detailPoint;
				return "toinput";	//只有找到entity才是更新
			}
		}
		return "tolist";	//不是更新则重定向回list
	}

	// 提交更改，以有没有Id值判断是插入还是修改
	public String subinput() {
		if (getModel().getId() == null || getModel().getId().equals("")) { // 插入
			detailPointServices.add(getModel());
		} else { // 更新
			detailPointServices.update(getModel());
		}
		return "tolist";
	}

	public String adminList(){
		if(getKey() == null || getKey().equals(""))
			return "togenerallist";
		getPage().setPageSize(100);	//细知识数量不能过多，因此不必分页。
		detailPointServices.listByGeneralPointId(getPage(), getKey());
		getModel().setGeneralPoint(generalPointServices.findEntityById(getKey()));
		return "adminlist";
	}

	public String delete(){
		this.model.setId(getKey());
		detailPointServices.deleteLogic(getModel());
		return "tolist";
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

	public GeneralPointServices getGeneralPointServices() {
		return generalPointServices;
	}

	public void setGeneralPointServices(GeneralPointServices generalPointServices) {
		this.generalPointServices = generalPointServices;
	}
}
