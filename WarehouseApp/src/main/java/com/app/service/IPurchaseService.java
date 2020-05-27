package com.app.service;

import java.util.List;

import com.app.model.Purchase;
import com.app.model.PurchaseDetails;

public interface IPurchaseService {

	public Integer savePurchase(Purchase p);
	public void updatePurchase(Purchase p);
	public void deletePurchase(Integer id);
	public Purchase getOnePurchase(Integer id);
	public List<Purchase> getAllPurchases();
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails);
	public List<Object[]> getPurchaseIdAndCode();
	void updateStatusById(Integer id, String status);
	

}
