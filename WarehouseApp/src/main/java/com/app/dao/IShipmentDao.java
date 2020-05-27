package com.app.dao;

import java.util.List;

import com.app.model.Shipment;

public interface IShipmentDao {
	public Integer saveShipment(Shipment s);
	public void updateShipment(Shipment s);
	public void deleteShipment(Integer id);
	public Shipment getOneShipment(Integer id);
	public List<Shipment> getAllShipments();
	public List<Object[]> getShipmentTypeAndCount();
	public List<Object[]> getShipmentIdAndCode();
}
