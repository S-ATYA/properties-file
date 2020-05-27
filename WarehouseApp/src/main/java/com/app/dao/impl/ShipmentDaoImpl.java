package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentDao;
import com.app.model.Shipment;

@Repository
public class ShipmentDaoImpl implements IShipmentDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveShipment(Shipment s) {
		
		return (Integer)ht.save(s);
	}

	
	public void updateShipment(Shipment s) {
		ht.update(s);
	}

	
	public void deleteShipment(Integer id) {
		Shipment s=new Shipment();
		s.setId(id);
		ht.delete(s);
	}

	public Shipment getOneShipment(Integer id) {
		Shipment s=ht.get(Shipment.class, id);
		return s;
	}

	public List<Shipment> getAllShipments() {
		List<Shipment> list=ht.loadAll(Shipment.class);
		return list;
	}


	
	@Override
	public List<Object[]> getShipmentTypeAndCount() {
		//String hql=" select shipmentType,count(shipmentType) from com.app.model.ShipmentType group by shipmentType";
		
		DetachedCriteria dc=DetachedCriteria.forClass(Shipment.class).setProjection(Projections.projectionList()
					.add(Projections.groupProperty("shipmentType")).add(Projections.count("shipmentType"))
				);
		@SuppressWarnings("unchecked")
		List<Object[]>list=(List<Object[]>) ht.findByCriteria(dc);
		return list;
	}


	
	@Override
	public List<Object[]> getShipmentIdAndCode() {
		/*
		 * String
		 * hql=" select id,shipmentCode from com.app.model.ShipmentType where shipmentEnable='YES' "
		 * ; return (List<Object[]>) ht.find(hql);
		 */
		DetachedCriteria dc=DetachedCriteria.forClass(Shipment.class).setProjection(Projections.projectionList()
					.add(Projections.property("id")).add(Projections.property("shipmentCode"))
				).add(Restrictions.eq("shipmentEnable", "YES"));
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(dc);
		return list;
	}

}
