package com.jersey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.dao.UserDao;

@Service
public class HelloService {
	
	@Autowired
	private UserDao userDao;
	
	public String sayHelloToUser(String id){
		return "Hello " + userDao.getUser(id).getName();
	}
}
