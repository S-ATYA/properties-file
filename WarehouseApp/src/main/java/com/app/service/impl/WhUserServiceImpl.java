package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUSerDao;
import com.app.model.WhUser;
import com.app.service.IWhUserService;

@Service
public class WhUserServiceImpl implements IWhUserService {

	@Autowired
	private IWhUSerDao dao;
	@Transactional
	public Integer saveWhUser(WhUser wh) {
		return dao.saveWhUser(wh);
	}

	@Transactional
	public void updateWhUser(WhUser wh) {
		dao.updateWhUser(wh);
	}

	@Transactional
	public void deleteWhUser(Integer id) {
		dao.deleteWhUser(id);
	}

	@Transactional(readOnly=true)
	public WhUser getOneWhUser(Integer id) {
		return dao.getOneWhUser(id);
	}

	@Transactional(readOnly=true)
	public List<WhUser> getAllWhUsers() {
		return dao.getAllWhUsers();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeIdAndCodesByType(String userType) {
		return dao.getWhUserTypeIdAndCodesByType(userType);
	}

}
