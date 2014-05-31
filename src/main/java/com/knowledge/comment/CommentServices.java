package com.knowledge.comment;


import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;

public class CommentServices  implements KnowledgeServices<Comment>  {
	CommentDao commentDao;
	DictionaryServices dictionaryServices;
	
	@Override
	public int add(Comment t) {

		int maxImportanceCode = 0, maxComplexityCode = 0;
		try {
			maxImportanceCode = dictionaryServices.findMaxCodeByFieldCode(3);
			maxComplexityCode = dictionaryServices.findMaxCodeByFieldCode(4);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(t.getComment() == null || t.getNote() == null ||
				t.getImportance() <= 0 || t.getImportance() > maxImportanceCode||
				t.getComplexity() <= 0 || t.getComplexity() > maxComplexityCode){
			return 0;
		}
		t.setId(UUID.randomUUID().toString());
		t.setUpdateTime(new Date());
		return commentDao.create(t);
	}

	@Override
	public int remove(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment findEntity(Comment t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Comment> list(){
		
		return commentDao.list();
	}
	

	//get & set method
	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}

}
