package com.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Sale;
import com.app.service.ISaleService;
import com.app.service.IShipmentService;
import com.app.util.CommonUtil;
import com.app.view.SaleExcelView;
import com.app.view.SalePdfView;

@Controller
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private ISaleService service;
	
	@Autowired
	private IShipmentService shipService;

	@RequestMapping("/register")
	public String showReq(ModelMap map)
	{
		map.addAttribute("sale",new Sale());
		List<Object[]> shipmentlist=shipService.getShipmentIdAndCode();
		Map<Integer,String> shipments=CommonUtil.convertData(shipmentlist);
		map.addAttribute("shipments",shipments);
		return "SaleRegister";
	
		
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Sale s,ModelMap map)
	{
		Integer id=service.saveSale(s);
		String msg="sale ' "+id+" ' created";
		map.addAttribute("message",msg);
		return "SaleRegister";
	}

	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<Sale> sale=service.getAllSale();
		map.addAttribute("sale",sale);
		return "SaleData";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		service.deleteSale(id);
		List<Sale> sale=service.getAllSale();

		String msg="Deleted '"+id+"' successfully";
		map.addAttribute("message",msg);
		map.addAttribute("sale",sale);
		return "SaleData";
	}

	@RequestMapping("/edit")
	public String  showEdit(@RequestParam Integer id,ModelMap map)
	{
		Sale s=service.getOneSale(id);
		map.addAttribute("sale",s);
		return "SaleEdit";
	}
	

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Sale sale,ModelMap map) 
	{
		service.updateSale(sale);
		String msg="sale created '"+sale.getId()+"' successfully";
		map.addAttribute("message",msg);
		List<Sale> sales=service.getAllSale();
		map.addAttribute("sale",sales);
		return "SaleData";
		
	}
	
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map)
	{
		Sale sale=service.getOneSale(id);
		map.addAttribute("ob",sale);
		return "SaleView";
		
	}
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false) Integer id)
	{
		List<Sale> sales=null;
		if(id==null)
		{
	        sales=service.getAllSale();
		 }
		else 
		{
			Sale s=service.getOneSale(id);
			sales=Arrays.asList(s);
	     }
		ModelAndView m=new ModelAndView();
		m.setView(new SaleExcelView());
		m.addObject("list",sales);
		return m;
	}
	
	@RequestMapping("/pdf")
	public  ModelAndView pdf(@RequestParam (required=false) Integer id)
	{
		List<Sale> sales=null;
		if(id==null)
		{
			sales=service.getAllSale();
		}
		else
		{
			sales=Arrays.asList(service.getOneSale(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new SalePdfView());
		m.addObject("list",sales);
		return m;
	}

	


}
