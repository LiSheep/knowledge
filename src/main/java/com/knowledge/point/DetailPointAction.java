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
	private GeneralPointServices generalPointServices;
	private DictionaryServices dictionaryServices;
	
	@Override
	public DetailPoint getModel() {
		if(model == null){
			model = new DetailPoint();
		}
		return model;
	}

	public String toinput(){
		setSessions();
		String keyString = getKey();
		if ( keyString == null || !keyString.equals("")){ // 更新界面需要的值
			DetailPoint detailPoint = detailPointServices.findEntityById(keyString);
			if(detailPoint != null){
				return "toinput";	//只有找到entity才是更新
			}
		}
		this.model = null;
		return "toinput";
		
	}
	
	// 提交更改，以有没有Id值判断是插入还是修改
		public String subinput() {
			if (getModel().getId() == null || getModel().getId().equals("")) { // 插入
				detailPointServices.add(getModel());
			} else { // 更新
				detailPointServices.update(getModel());
			}
			this.model = null;	//TODO:这里有一个问题，如果不至空，其他toinput请求也会获取到model的值。 -ltc 2014/06/03
			return "tolist";
		}
	
	public String adminList(){
		if(getKey() == null ||getKey().equals(""))
			return "togenerallist";
		detailPointServices.listByGeneralPointId(getPage(), getKey());
		return "adminlist";
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
