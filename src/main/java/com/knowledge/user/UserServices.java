package com.knowledge.user;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.knowledge.arc.KnowledgeServices;
import com.knowledge.dictionary.DictionaryServices;
import com.opensymphony.xwork2.ActionContext;

public class UserServices implements KnowledgeServices<User> {

	//register user
	@Override
	public int add(User t) {
		try {
			t.setId(UUID.randomUUID().toString());
			t.setRole(dictionaryServices.findDictionary(6, 2).getCode());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
			
		return userDao.create(t);
	}
	
	public User findUserSession() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	@Override
	public int remove(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	//user login user select by username and userpass
	@Override
	public User findEntity(User t) {
		
		return userDao.readEntity(t);
	}

	@Override
	public User findEntityById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogic(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private DictionaryServices dictionaryServices;

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
}
