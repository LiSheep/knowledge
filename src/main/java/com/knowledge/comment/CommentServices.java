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
		List<Dictionary> importancedict = null;
		List<Dictionary> complexityDict = null;
		try {
			importancedict = dictionaryServices.findLabels(3);
			complexityDict = dictionaryServices.findLabels(4);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxImportanceCode = importancedict.get(importancedict.size() -1 ).getCode();
		int maxComplexityCode = complexityDict.get(complexityDict.size() -1 ).getCode();
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
	public int find(Comment t) {
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
