package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {
	
	 public Integer saveUser(User u);
	  public void updateUser(User u);
	  public void deleteUser(Integer id);
	  public User  getOneUser(Integer id);
	  public List<User> getAllUser();


}
