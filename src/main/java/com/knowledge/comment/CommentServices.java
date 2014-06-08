package com.knowledge.comment;


import java.util.List;
import java.util.UUID;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.dictionary.DictionaryServices;
import com.knowledge.page.Page;

public class CommentServices  implements KnowledgeServices<Comment>  {
	CommentDao commentDao;
	DictionaryServices dictionaryServices;
	
	@Override
	public int add(Comment t) {

//		int maxImportanceCode = 0, maxComplexityCode = 0;
//		try {
//			maxImportanceCode = dictionaryServices.findMaxCodeByFieldCode(3);
//			maxComplexityCode = dictionaryServices.findMaxCodeByFieldCode(4);
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(t.getImportance() <= 0 || t.getImportance() > maxImportanceCode||
//				t.getComplexity() <= 0 || t.getComplexity() > maxComplexityCode){
//			return 0;
//		}
		t.setId(UUID.randomUUID().toString());
		return commentDao.create(t);
	}

	@Override
	public List<Comment> list(Page<Comment> page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Comment> listByGeneralPointId(Page<Comment> page, Object gId){
		commentDao.listByGeneralPointId(page, gId);
		return null;
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
	
	public Comment findEntityByGPointIdAndUserId(Object gid, Object uid){
		return commentDao.readEntityByGPointIdAndUserId(gid, uid);
	}
	
	@Override
	public int update(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//只更新笔记
	public int updateNote(Comment t) {
		return commentDao.updateNote(t);
	}
	
	//只更新评论
	public int updateComment(Comment t){
		if(t.getComment() == null || t.getComment().equals("")){
			return 0;
		}
		return commentDao.updateComment(t);
	}
	
	@Override
	public int deleteLogic(Comment t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment findEntityById(Object id) {
		return commentDao.readEntityById(id);
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
