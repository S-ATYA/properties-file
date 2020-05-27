package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom u) {

		return (Integer)ht.save(u);
	}

	@Override
	public void updateUom(Uom u) {
		ht.update(u);

	}

	@Override
	public void deleteUom(Integer id) {
		Uom u=ht.get(Uom.class, id);
		u.setId(id);
		ht.delete(u);

	}

	@Override
	public Uom getOneUom(Integer id) {
		Uom u=ht.get(Uom.class,id);
		return u;
	}

	@Override
	public List<Uom> getAllUom() {
		List<Uom> u=ht.loadAll(Uom.class);
		return u;
	}
	@Override
	public List<Object[]> getOrderTypeAndCount() {
		//		String hql="select uomType,count(uomType) from com.app.model.Uom group by uomType";
		//		return (List<Object[]>)ht.find(hql);
		DetachedCriteria dc=DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("uomType"))
						.add(Projections.count("uomType"))	 
						);

		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(dc);	   
		return list;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomTypeAndModels() {
		//		String hql="select id,uomModel from com.app.model.Uom";
		//		return (List<Object[]>)ht.find(hql);
		DetachedCriteria dc=DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("uomModel")));

		List<Object[]> list= (List<Object[]>)ht.findByCriteria(dc);

		return list;

	}
	@Override
	public boolean isModelExist(String uomModel) {
		boolean flag=false;
//		String hql=" select count(uomModel) from com.app.model.Uom where uomModel=?0";

//		@SuppressWarnings({ "deprecation", "unchecked" })
//		List<Long> res=(List<Long>)ht.find(hql,uomModel);
		DetachedCriteria dc=DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
						.add(Projections.count("uomModel"))
						.add((Projection) Restrictions.eq("uomModel","uomModel")));
		@SuppressWarnings("unchecked")
		List<Long> res=(List<Long>)ht.findByCriteria(dc);
		
		if(res!=null && !res.isEmpty())
		{
			long count=res.get(0);
			flag=(count==1)?true:false;

		}
		return flag;
	}

}
