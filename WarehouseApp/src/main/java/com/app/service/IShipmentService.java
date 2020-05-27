package com.app.service;

import java.util.List;

import com.app.model.Shipment;

public interface IShipmentService {
	public Integer saveShipment(Shipment s);
	public void updateShipment(Shipment s);
	public void deleteShipment(Integer id);
	public Shipment getOneShipment(Integer id);
	public List<Shipment> getAllShipments();
	public List<Object[]> getShipmentTypeAndCount();
	public List<Object[]> getShipmentIdAndCode();
}
