package com.app.dao;

import java.util.List;

import com.app.model.Part;


public interface IPartDao {
	
	public Integer savePart(Part p);
	  public void updatePart(Part p);
	  public void deletePart(Integer id);
	  public Part getOnePart(Integer id);
	  public List<Part> getAllPart();
	  public List<Object[]> getIdCode();


}
