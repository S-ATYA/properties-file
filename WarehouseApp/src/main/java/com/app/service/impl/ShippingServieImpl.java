package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;
import com.app.service.IShippingService;
@Service
public class ShippingServieImpl implements IShippingService {

	@Autowired
	private IShippingDao dao;
	
	@Override
	@Transactional
	public Integer saveShipping(Shipping s) {
		
		return dao.saveShipping(s);
	}

	@Override
	@Transactional
	public void updateShipping(Shipping s) {
		dao.updateShipping(s);

	}

	@Override
	@Transactional
	public void deleteShipping(Integer id) {
		dao.deleteShipping(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Shipping getOneShipping(Integer id) {
		
		return dao.getOneShipping(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Shipping> getAllShipping() {
		
		return dao.getAllShipping();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getShippingTypeAndCount() {
	
		return dao.getShippingTypeAndCount();
	}

}
