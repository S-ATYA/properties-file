package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISaleDao;
import com.app.model.Sale;
import com.app.service.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService {

	@Autowired
	private ISaleDao dao;
	
	@Override
    @Transactional
	public Integer saveSale(Sale s) {
		return dao.saveSale(s);
	}

	@Override
    @Transactional
	public void updateSale(Sale s) {
	    dao.updateSale(s);

	}

	@Override
    @Transactional
	public void deleteSale(Integer id) {
		dao.deleteSale(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Sale getOneSale(Integer id) {
		
		return dao.getOneSale(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sale> getAllSale() {
		
		return dao.getAllSale();
	}

}
