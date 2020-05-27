package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {
	
	 public Integer saveUser(User u);
	  public void updateUser(User u);
	  public void deleteUser(Integer id);
	  public User  getOneUser(Integer id);
	  public List<User> getAllUser();

}
