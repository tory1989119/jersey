package com.jersey.dao;

import com.jersey.model.User;

public interface UserDao {
	public User getUser(String id);
	
	public void addUser(String name);
	
	public void updateUser(User user);
}
