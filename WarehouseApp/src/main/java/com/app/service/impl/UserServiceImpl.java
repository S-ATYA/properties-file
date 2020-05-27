package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Override
	public Integer saveUser(User u) {
		
		return dao.saveUser(u);
	}

	@Override
	public void updateUser(User u) {
		dao.updateUser(u);

	}

	@Override
	public void deleteUser(Integer id) {
		dao.deleteUser(id);

	}

	@Override
	public User getOneUser(Integer id) {
		
		return dao.getOneUser(id);
	}

	@Override
	public List<User> getAllUser() {
		
		return dao.getAllUser();
	}

}
