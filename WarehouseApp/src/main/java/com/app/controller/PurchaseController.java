package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Purchase;
import com.app.model.PurchaseDetails;
import com.app.service.IPartService;
import com.app.service.IPurchaseService;
import com.app.service.IShipmentService;
import com.app.service.IWhUserService;
import com.app.util.CommonUtil;
import com.app.view.PurchaseExcelView;
import com.app.view.PurchasePdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private IPurchaseService service;
	
	@Autowired
	private IShipmentService shipmentService;
	
	@Autowired
	private IWhUserService whUserService;
	
	@Autowired
	private IPartService partService;
	
	
	/**
	 * DropDown UI  common method
	 */
	
	private void addCommonUI(ModelMap map){
		List<Object[]> purchaseList=shipmentService.getShipmentIdAndCode();
		Map<Integer,String> shipmentCode=CommonUtil.convertData(purchaseList);
		map.addAttribute("shipmentCode", shipmentCode);
		List<Object[]> whUserLists=whUserService.getWhUserTypeIdAndCodesByType("VENDOR");
		Map<Integer,String> whuserCode=CommonUtil.convertData(whUserLists);
		map.addAttribute("whUserType", whuserCode);
		
	}
	
	/**1 displaying purchase register page
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/register")
	public String showReg(ModelMap map){
		Purchase p=new Purchase();
		p.setDefaultStatus("OPEN");
		map.addAttribute("purchase", p);
		addCommonUI(map);
		return "PurchaseRegister";
	}
	
	//2. saving data into database
	@RequestMapping(value="/save",method=POST)
	public String savePurchase(@ModelAttribute Purchase purchase, ModelMap map) {
		//calling service layer
		Integer id=service.savePurchase(purchase);
		String message="Purchase '"+id+"' created successfully";
		map.addAttribute("msg", message);
		addCommonUI(map);
		return "PurchaseRegister";
	}

	//3. fetching all rows from database 
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Purchase> purchase=service.getAllPurchases();
		map.addAttribute("list", purchase);
		return "PurchaseData";
	}
	
	//4. showing one row from database to UI
	@RequestMapping("/view")
	public String showMore(@RequestParam Integer id,ModelMap map) {
		Purchase purchases=service.getOnePurchase(id);
		map.addAttribute("ob", purchases);
		return "PurchaseView";
	}
	
	//5. showing edit page 
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		Purchase p=service.getOnePurchase(id);
		map.addAttribute("purchase", p);
		addCommonUI(map);
		return "PurchaseEdit";
	}
	//6. updating one row 
	@RequestMapping(value="/update",method=POST)
	public String updatePurchase(@ModelAttribute Purchase purchase,ModelMap map) {
		service.updatePurchase(purchase);
		String message="Purchase'"+purchase.getId()+"' updated SuccessFully!!";
		map.addAttribute("msg", message);
		List<Purchase> p=service.getAllPurchases();
		map.addAttribute("list", p);
		return "PurchaseData";
	}
	
	//7.deleting one row 
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		service.deletePurchase(id);
		List<Purchase> p=service.getAllPurchases();
		String message="Purchase id Number'"+id+"' deleted successfully";
		map.addAttribute("msg", message);
		map.addAttribute("list", p);
		return "PurchaseData";
	}
	
	//8 exporting excel
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false) Integer id) {
		List<Purchase> purs=null;
		if (id==null) {
			purs=service.getAllPurchases();
		}else {
			Purchase p=service.getOnePurchase(id);
			purs=Arrays.asList(p);
			
		}
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseExcelView());
		m.addObject("list", purs);
		return m;
	}
	//9. exporting pdf
	
	@RequestMapping("/pdf")
	public ModelAndView exortPdf(@RequestParam(required=false) Integer id) {
		List<Purchase> purs=null;
		if (id==null) {
			purs=service.getAllPurchases();
		}
		else {
			Purchase p=service.getOnePurchase(id);
			purs=Arrays.asList(p);
			
		}
		ModelAndView m=new ModelAndView();
		m.setView(new PurchasePdfView());
		m.addObject("list", purs);
		
		return m;
	}

	//show purchaseDetails page
	@RequestMapping("/part")
	public String showParts(@RequestParam Integer id,ModelMap map) {
		//Form Backing Object
		PurchaseDetails purchaseDetails=new PurchaseDetails();
		
		purchaseDetails.setParent(new Purchase(id));
		map.addAttribute("purchaseDetails", purchaseDetails);
		Purchase po=service.getOnePurchase(id);
		map.addAttribute("parent", po);
		
		//Drop Down data for parts
		List<Object[]> list=partService.getIdCode();
		Map<Integer,String> partList=CommonUtil.convertData(list);
		map.addAttribute("partsDetails", partList);
		
		return "PurchaseDetails";
	}
	@RequestMapping(value="/add",method=POST)
	public String addParts(@ModelAttribute PurchaseDetails purchaseDetails,ModelMap map) {
		service.savePurchaseDetails(purchaseDetails);
		
		return " redirect:part?id= "+purchaseDetails.getParent().getId();
	}
}
