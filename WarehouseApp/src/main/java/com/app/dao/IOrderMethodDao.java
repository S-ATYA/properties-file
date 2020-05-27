package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;


public interface IOrderMethodDao {

	 public Integer saveOrderMethod(OrderMethod o);
	  public void updateOrderMethod(OrderMethod o);
	  public void deleteOrderMethod(Integer id);
	  public OrderMethod getOneOrderMethod(Integer id);
	  public List<OrderMethod> getAllOrderMethod();
	  public List<Object[]> getOrderTypeAndCount();
	  public List<Object[]> getOrderMethodIdAndOrderCode();
}
