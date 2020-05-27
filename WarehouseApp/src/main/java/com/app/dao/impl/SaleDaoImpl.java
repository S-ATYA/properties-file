package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleDao;
import com.app.model.Sale;


@Repository
public class SaleDaoImpl implements ISaleDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveSale(Sale s) {
		
		return (Integer)ht.save(s);
	}

	@Override
	public void updateSale(Sale s) {
		
		ht.update(s);

	}

	@Override
	public void deleteSale(Integer id) {
		Sale s=ht.get(Sale.class, id);
		s.setId(id);
		ht.delete(s);

	}

	@Override
	public Sale getOneSale(Integer id) {
		Sale s=ht.get(Sale.class, id);
		return s;
	}

	@Override
	public List<Sale> getAllSale() {
		List<Sale> s=ht.loadAll(Sale.class);
		return s;
	}

}
