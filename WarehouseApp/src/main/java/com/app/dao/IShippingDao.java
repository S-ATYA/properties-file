package com.app.dao;

import java.util.List;

import com.app.model.Shipping;


public interface IShippingDao {

	 public Integer saveShipping(Shipping s);
	  public void updateShipping(Shipping s);
	  public void deleteShipping(Integer id);
	  public Shipping getOneShipping(Integer id);
	  public List<Shipping> getAllShipping();
	  public List<Object[]> getShippingTypeAndCount();

}
