package com.app.dao;

import java.util.List;

import com.app.model.Sale;


public interface ISaleDao {
	
	public Integer saveSale(Sale s);
	  public void updateSale(Sale s);
	  public void deleteSale(Integer id);
	  public Sale getOneSale(Integer id);
	  public List<Sale> getAllSale();

}
