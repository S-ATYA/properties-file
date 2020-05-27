package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod o) {
		return (Integer)ht.save(o);
	}

	@Override
	public void updateOrderMethod(OrderMethod o) {
		ht.update(o);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod o=ht.get(OrderMethod.class, id);
		o.setId(id);
		ht.delete(o);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		OrderMethod o=ht.get(OrderMethod.class,id);
		return o;
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> o=ht.loadAll(OrderMethod.class);
		return o;
	
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getOrderTypeAndCount() {
		String hql="select orderMode,count(orderMode) from com.app.model.OrderMethod group by orderMode";
		return (List<Object[]>)ht.find(hql);
	}
	@Override
	public List<Object[]> getOrderMethodIdAndOrderCode() {
		String hql="select id,orderCode from com.app.model.OrderMethod";
		return (List<Object[]>)ht.find(hql);
	}

}
