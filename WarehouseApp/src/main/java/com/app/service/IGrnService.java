package com.app.service;

import java.util.List;

import com.app.model.Grn;
import com.app.model.GrnDtl;

public interface IGrnService {

	 public Integer saveGrn(Grn g);
	  public void updateGrn(Grn g);
	  public void deleteGrn(Integer id);
	  public Grn getOneGrn(Integer id);
	  public List<Grn> getAllGrn();
	  public List<Object[]> getGrnTypeAndCount();
	  Integer saveGrnDtl(GrnDtl dtl);
	  public List<GrnDtl> getGrnDtlByGrnId(Integer id); 

	

}
