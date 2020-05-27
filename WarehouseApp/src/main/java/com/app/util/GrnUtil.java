package com.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Grn;
import com.app.model.GrnDtl;
import com.app.model.Purchase;
import com.app.model.PurchaseDetails;
import com.app.service.IGrnService;
import com.app.service.IPurchaseService;
@Component
public class GrnUtil {
	@Autowired
	private IGrnService service;
	@Autowired
	private IPurchaseService purchaseService;
	
	public void saveGrnDtls(Grn grn) {
		//read first purchase by pid
		Purchase po=purchaseService.getOnePurchase(grn.getPurchase().getId());
		
		//from purchase read PurchaseDtls
		List<PurchaseDetails> pdtls=po.getChilds();
		
		// One PurchaseDtl -> one GrnDtl
		for(PurchaseDetails pdtl:pdtls) {
			GrnDtl gdtl=new GrnDtl();
			gdtl.setItemCode(pdtl.getPart().getPartCode());
			gdtl.setBaseCost(pdtl.getPart().getBaseCost());
			gdtl.setQnty(pdtl.getQuantity());
			gdtl.setItemVal(gdtl.getBaseCost()*gdtl.getQnty());
			
			//link with (GrnId)PrimaryKey as Fk
			//for bi-directional code 
			gdtl.setParent(new Grn(grn.getId()));
			//save GrnDtl
			service.saveGrnDtl(gdtl);
		}
		
	}
}