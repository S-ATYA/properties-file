package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod o) {
		return dao.saveOrderMethod(o);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod o) {
		dao.updateOrderMethod(o);

	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);

	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethod() {
		// TODO Auto-generated method stub
		return dao.getAllOrderMethod();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getUomTypeAndCount() {

		return dao.getOrderTypeAndCount();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getOrderMethodIdAndOrderCode() {
		
		return dao.getOrderMethodIdAndOrderCode();
	}
}
