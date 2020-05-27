package com.app.service;

import java.util.List;

import com.app.model.WhUser;

public interface IWhUserService {

	public Integer saveWhUser(WhUser wh);
	public void updateWhUser(WhUser wh);
	public void deleteWhUser(Integer id);
	public WhUser getOneWhUser(Integer id);
	public List<WhUser> getAllWhUsers();
	public List<Object[]> getWhUserTypeIdAndCodesByType(String userType);
	
}
