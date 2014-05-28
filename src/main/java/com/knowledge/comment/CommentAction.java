package com.knowledge.comment;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment> {

	private static final long serialVersionUID = 8588855865774891306L;
	private Comment model;
	private CommentServices commentServices;
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

	public String input(){
		return "add";
	}
	
	public String add(){
		commentServices.add(getModel());
		return "list";
	}
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
}
