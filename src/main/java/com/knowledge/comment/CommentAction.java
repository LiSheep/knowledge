package com.knowledge.comment;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment> {

	private static final long serialVersionUID = 8588855865774891306L;
	private Comment model;
	private CommentServices commentServices;
	private DictionaryServices dictionaryServices;
	private List<Comment> entities;
	
	@Override
	public Comment getModel() {
		if (null == model) {
			model = new Comment();
		}
		return model;
	}
	
	public String list(){
		this.setEntities(commentServices.list());
		return "list";
	}

	private List<Dictionary> importanceDict;
	private List<Dictionary> complexityDict;
	
	public String input(){
		
		return "add";
	}
	
	public String add(){
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

	public List<Comment> getEntities() {
		return entities;
	}

	public void setEntities(List<Comment> entities) {
		this.entities = entities;
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
	
}
