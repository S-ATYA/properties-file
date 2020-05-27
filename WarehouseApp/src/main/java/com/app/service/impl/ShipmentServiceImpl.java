package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentDao;
import com.app.model.Shipment;
import com.app.service.IShipmentService;

@Service
public class ShipmentServiceImpl implements IShipmentService {

	@Autowired
	private IShipmentDao dao;
	

	@Transactional
	public Integer saveShipment(Shipment s) {
		return dao.saveShipment(s);
	}

	@Transactional
	public void updateShipment(Shipment s) {
		dao.updateShipment(s);
	}

	@Transactional
	public void deleteShipment(Integer id) {
		dao.deleteShipment(id);
	}

	@Transactional(readOnly=true)
	public Shipment getOneShipment(Integer id) {
		return dao.getOneShipment(id);
	}

	@Transactional(readOnly=true)
	public List<Shipment> getAllShipment() {
		return dao.getAllShipments();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getShipmentTypeAndCount() {
		return dao.getShipmentTypeAndCount();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getShipmentIdAndCode() {
		return dao.getShipmentIdAndCode();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Shipment> getAllShipments() {
		
		return dao.getAllShipments();
	}

}
