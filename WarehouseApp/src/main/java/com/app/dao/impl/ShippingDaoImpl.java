package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;


@Service
public class ShippingDaoImpl implements IShippingDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipping(Shipping s) {
		return(Integer)ht.save(s);
	}

	@Override
	public void updateShipping(Shipping s) {
		ht.update(s);

	}

	@Override
	public void deleteShipping(Integer id) {
		Shipping  s=ht.get(Shipping.class, id);
		s.setId(id);
		ht.delete(s);


	}

	@Override
	public Shipping getOneShipping(Integer id) {
		Shipping  s=ht.get(Shipping.class, id);
		return s;
	}

	@Override
	public List<Shipping> getAllShipping() {
		List<Shipping> s=ht.loadAll(Shipping.class);
		return s;
		
	}
	@Override
	public List<Object[]> getShippingTypeAndCount() {
//		String hql="select shippingCode,count(shippingCode) from com.app.model.Shipping group by shippingCode";
		DetachedCriteria dc=DetachedCriteria.forClass(Shipping.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("shippingCode"))
				.add(Projections.count("shipppingCode")));
		return (List<Object[]>)ht.findByCriteria(dc);
	}

}
