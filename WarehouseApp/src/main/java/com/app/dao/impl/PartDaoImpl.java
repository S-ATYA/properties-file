package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPartDao;
import com.app.model.Part;


@Repository
public class PartDaoImpl implements IPartDao {


	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePart(Part p) {
		
		return (Integer)ht.save(p);
	}

	@Override
	public void updatePart(Part p) {
		ht.update(p);

	}

	@Override
	public void deletePart(Integer id) {
		Part p=ht.get(Part.class, id);
		p.setId(id);
		ht.delete(p);

	}

	@Override
	public Part getOnePart(Integer id) {
		Part p=ht.get(Part.class,id);
		return p;
	}

	@Override
	public List<Part> getAllPart() {
		List<Part> p=ht.loadAll(Part.class);
		return p;
	}

	@Override
	public List<Object[]> getIdCode() {
		DetachedCriteria dc=DetachedCriteria.forClass(Part.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("partCode")));
		return (List<Object[]>) ht.findByCriteria(dc);
	}

}
