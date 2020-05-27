package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDetails;
import com.app.service.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

	@Autowired
	private IPurchaseDao dao;
	
	@Transactional
	public Integer savePurchase(Purchase p) {
		return dao.savePurchase(p);
	}

	@Transactional
	public void updatePurchase(Purchase p) {
		dao.updatePurchase(p);
	}

	@Transactional
	public void deletePurchase(Integer id) {
		dao.deletePurchase(id);
	}

	@Transactional(readOnly=true)
	public Purchase getOnePurchase(Integer id) {
		return dao.getOnePurchase(id);
	}

	@Transactional(readOnly=true)
	public List<Purchase> getAllPurchases() {
		return dao.getAllPurchases();
	}
	
	@Transactional
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails) {
		
		return dao.savePurchaseDetails(purchaseDetails);
	}

	@Override
	@Transactional
	public List<Object[]> getPurchaseIdAndCode() {
		
		return dao.getPurchaseIdAndCode();
	}

	@Override
	@Transactional
	public void updateStatusById(Integer id, String status) {
		dao.updateStatusById(id, status);
		
	}
}
