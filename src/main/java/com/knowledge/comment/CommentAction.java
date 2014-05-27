package com.knowledge.comment;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment> {

	private static final long serialVersionUID = 8588855865774891306L;
	private Comment model;
	private CommentServices commentServices;
	
	@Override
	public Comment getModel() {
		if (null == model) {
			model = new Comment();
		}
		return model;
	}
	
	public String list(){
		commentServices.list();
		return "list";
	}

	public CommentServices getCommentServices() {
		return commentServices;
	}

	public void setCommentServices(CommentServices commentServices) {
		this.commentServices = commentServices;
	}

}
