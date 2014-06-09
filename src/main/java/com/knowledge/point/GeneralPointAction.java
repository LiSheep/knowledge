package com.knowledge.point;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

/*
 * GeneralPoint Action
 * ltc: 2014/06/08
 */
public class GeneralPointAction extends KnowledgeAction<GeneralPoint> {

	private static final long serialVersionUID = -4973793253208227806L;
	private GeneralPointServices generalPointServices;
	private DetailPointServices detailPointServices;
	private DictionaryServices dictionaryServices;

	public String toinput() {
		setSessions();
		String keyString = getKey();
		if ( keyString == null || !keyString.equals("")){ // 更新界面需要的值
			this.model = generalPointServices.findEntityById(keyString);
		}
		return "toinput";
	}

	// 提交更改，以有没有Id值判断是插入还是修改
	public String subinput() {
		if (getModel().getId() == null || getModel().getId().equals("")) { // 插入
			generalPointServices.add(getModel());
		} else { // 更新
			generalPointServices.update(getModel());
		}
//		this.model = null;	//TODO:这里有一个问题，如果不至空，其他toinput请求也会获取到model的值。 -ltc 2014/06/03
		return "tolist";
	}

	// 粗知识点管理列表
	public String adminList() {
		if(getKey() == null || getKey().equals("")){
			generalPointServices.list(getPage());
		}else {
			generalPointServices.listByPointType(Integer.valueOf(getKey()), getPage());
		}
		
		return "adminlist";
	}
	
	//知识点详细显示
	public String detail(){
		this.model = generalPointServices.findEntityById(getKey());
		if(this.model == null)
			return "error";
		
		getModel().setDetailPoints(detailPointServices.listByGeneralPointId(getModel().getId()));
		return "detail";
	}

	// 删除粗知识点
	public String delete() {
		this.model.setId(getKey());
		generalPointServices.deleteLogic(getModel());
		return "tolist";
	}
	
	public void setSessions() {
		List<Dictionary> dicImportance = null;
		List<Dictionary> dicComplexity = null;
		List<Dictionary> dicType = null;
		//TODO:这个地方要改哦
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

	public DetailPointServices getDetailPointServices() {
		return detailPointServices;
	}

	public void setDetailPointServices(DetailPointServices detailPointServices) {
		this.detailPointServices = detailPointServices;
	}
}
