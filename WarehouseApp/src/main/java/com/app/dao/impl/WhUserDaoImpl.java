package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUSerDao;
import com.app.model.WhUser;

@Repository
public class WhUserDaoImpl implements IWhUSerDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveWhUser(WhUser wh) {
		return (Integer) ht.save(wh);
	}

	@Override
	public void updateWhUser(WhUser wh) {
		ht.update(wh);
	}

	@Override
	public void deleteWhUser(Integer id) {
		WhUser wh=new WhUser();
		wh.setId(id);
		ht.delete(wh);
	}

	@Override
	public WhUser getOneWhUser(Integer id) {
		WhUser wh=ht.get(WhUser.class, id);
		return wh;
	}

	@Override
	public List<WhUser> getAllWhUsers() {
		List<WhUser> list=ht.loadAll(WhUser.class);
		return list;
	}

	@Override
	public List<Object[]> getWhUserTypeIdAndCodesByType(String userType) {
		/*
		 * String
		 * hql=" select id,userCode from com.app.model.WhUser where userType=?0 ";
		 * return (List<Object[]>) ht.find(hql, userType);
		 */
		DetachedCriteria dc=DetachedCriteria.forClass(WhUser.class).setProjection(Projections.projectionList()
					.add(Projections.property("id")).add(Projections.property("userCode"))
				).add(Restrictions.eq("userType", userType));
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(dc);
		return list;
	}

}
