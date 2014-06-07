package com.knowledge.comment;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.knowledge.point.GeneralPoint;
import com.knowledge.point.GeneralPointServices;
import com.knowledge.user.User;
import com.opensymphony.xwork2.ActionContext;

public class CommentAction extends KnowledgeAction<Comment>{

	private static final long serialVersionUID = 8588855865774891306L;
	private CommentServices commentServices;
	private GeneralPointServices generalPointServices;
	private DictionaryServices dictionaryServices;
	
	public CommentAction(){
		super();
	}
	
	//显示General Point的list
	public String listGPoint(){
		GeneralPoint gPoint = generalPointServices.findEntityById(getKey());		//key为generalPoint
		if(gPoint == null)
			return "tomain";
		getModel().setGeneralPoint(gPoint);
		commentServices.listByGeneralPointId(getPage(), getKey());
		return "list";
	}

	public String input(){
		setSessions();
		return "input";
	}
	
	public String add(){	//TODO:还需要添加防止重复提交功能
		commentServices.add(getModel());
		return "list";
	}
	
	//提交学习笔记表单 
	public String subLearn(){
//		GeneralPoint gPoint = generalPointServices.findEntityById(getModel().getGeneralPoint().getId());
//		if(gPoint == null){
//			return "tolist";
//		}
//		getModel().setGeneralPoint(gPoint);
		getModel().setUser((User)ActionContext.getContext().getSession().get("user"));
		
		if(getModel().getId() == null || getModel().getId().equals("") ){
			commentServices.add(getModel());
		}
		else {
			commentServices.updateNote(getModel());
		}
		//设置key，用于toLearn();
		this.key = getModel().getGeneralPoint().getId();
		return toLearn();
	}
	
	public String tofinishLearn(){
		
		
		return "";
	}
	
	public String toLearn(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		this.model = commentServices.findEntityByGPointIdAndUserId(getKey(), user.getId());	
		getModel().setUser((User)ActionContext.getContext().getSession().get("user"));
		return "note";
	}
	
	//get & set method
	public CommentServices getCommentServices() {
		return commentServices;
	}

	public void setCommentServices(CommentServices commentServices) {
		this.commentServices = commentServices;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
	
	@Override
	public Comment getModel() {
		if (null == model) {
			model = new Comment();
		}
		return model;
	}
	
	public GeneralPointServices getGeneralPointServices() {
		return generalPointServices;
	}

	public void setGeneralPointServices(GeneralPointServices generalPointServices) {
		this.generalPointServices = generalPointServices;
	}

	public void setSessions() {
		List<Dictionary> dicImportance = null;
		List<Dictionary> dicComplexity = null;
		try {
//			dicImportance = dictionaryServices.findLabels(Integer.valueOf(getText("FieldImportance.fieldCode")));
//			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(getText("FieldComplexity.fieldCode")));
			dicImportance = dictionaryServices.findLabels(Integer.valueOf(3));
			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(4));
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
}
