package com.app.dao;

import java.util.List;

import com.app.model.WhUser;

public interface IWhUSerDao {

	public Integer saveWhUser(WhUser wh);
	public void updateWhUser(WhUser wh);
	public void deleteWhUser(Integer id);
	public WhUser getOneWhUser(Integer id);
	public List<WhUser> getAllWhUsers();
	public List<Object[]> getWhUserTypeIdAndCodesByType(String userType);
}
