package com.knowledge.comment;


import java.util.List;
import java.util.UUID;

import com.knowledge.arc.KnowledgeServices;

public class CommentServices  implements KnowledgeServices<Comment>  {
	CommentDao commentDao;
	
	@Override
	public int add(Comment t) {
		t.setId(UUID.randomUUID().toString());
		return commentDao.create(t);
	}

	@Override
	public int remove(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int find(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Comment> list(){
		
		return commentDao.list();
	}
	

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

}
