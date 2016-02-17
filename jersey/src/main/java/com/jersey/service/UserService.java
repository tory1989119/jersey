package com.jersey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.dao.UserDao;
import com.jersey.model.User;

@Service
@Transactional(readOnly=true)
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public String getUser(String id){
		return "Hello " + userDao.getUser(id).getName();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addUser(String name){
		userDao.addUser(name);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateUser(User user){
		userDao.updateUser(user);
	}
}
