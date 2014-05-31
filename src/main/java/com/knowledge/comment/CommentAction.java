package com.knowledge.comment;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

public class CommentAction extends KnowledgeAction<Comment>{

	private static final long serialVersionUID = 8588855865774891306L;
	private CommentServices commentServices;
	private DictionaryServices dictionaryServices;
	
	public CommentAction(){
		super();
	}
	public String list(){
		this.entities = commentServices.list();
		return "list";
	}

	private List<Dictionary> importanceDict;
	private List<Dictionary> complexityDict;
	
	public String input(){
		setSessions();
		return "add";
	}
	
	public String add(){	//TODO:还需要添加防止重复提交功能
		commentServices.add(getModel());
		return "list";
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

	
	public List<Dictionary> getImportanceDict() {
		//知识点重要程度-> dictionary:fieldCode=3
		try {
			importanceDict = dictionaryServices.findLabels(3);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importanceDict;
	}

	public List<Dictionary> getComplexityDict() {
		//知识点难易程度-> dictionary:fieldCode=4
		try {
			complexityDict = dictionaryServices.findLabels(4);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complexityDict;
	}
	
	public String getImportanceLabel(int code){
		try {
			return dictionaryServices.findDictionary(3, code).getLabel();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "系统错误";
		}
	}
	
	public String getComplexityLabel(int code){
		try {
			return dictionaryServices.findDictionary(4, code).getLabel();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "系统错误";
		}
	}

	@Override
	public Comment getModel() {
		if (null == model) {
			model = new Comment();
		}
		return model;
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
