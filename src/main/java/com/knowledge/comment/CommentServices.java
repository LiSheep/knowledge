package com.knowledge.comment;


import com.knowledge.arc.KnowledgeServices;

public class CommentServices  implements KnowledgeServices<Comment>  {
	CommentDao commentDao;
	
	@Override
	public int add(Comment t) {
		// TODO Auto-generated method stub
		return 0;
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
	
	public int list(){
		commentDao.list();
		return 0;
	}
	

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

}
