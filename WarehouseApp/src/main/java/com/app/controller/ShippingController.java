package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Shipping;
import com.app.service.IShippingService;
import com.app.util.ShippingUtil;
import com.app.view.ShippingExcelView;
import com.app.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
	private IShippingService service;

	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShippingUtil util;
	
	@RequestMapping("/register")
	public String showReq(ModelMap map)
	{
		map.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Shipping shipping,ModelMap map)
	{
		Integer id=service.saveShipping(shipping);
		String message="shipping '"+id+"' created";
		map.addAttribute("shipping",new Shipping());
		map.addAttribute("msg",message);
		return "ShippingRegister";
		
	}
	
	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<Shipping> shippings=service.getAllShipping();
		map.addAttribute("list",shippings);
		return "ShippingData";
		
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		service.deleteShipping(id);
		List<Shipping> shipping=service.getAllShipping();
		String msg="Deleted '"+id+"' success fully";
		map.addAttribute("list",shipping);
		map.addAttribute("msg",msg);
		return "ShippingData";
	}
	@RequestMapping("/edit")
	public String  showEdit(@RequestParam Integer id,ModelMap map)
	{
		Shipping s=service.getOneShipping(id);
		map.addAttribute("shipping",s);
		return "ShippingEdit";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Shipping s,ModelMap map)
	{
		service.updateShipping(s);
		String msg="SHIPPING '"+s.getId()+"' successfully";
		map.addAttribute("msg",msg);
		List<Shipping> shippings=service.getAllShipping();
		map.addAttribute("list",shippings);
		return "ShippingData";
	}
	
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map)
	{
		Shipping shipping=service.getOneShipping(id);
		map.addAttribute("ob",shipping);
		return "ShippingView";
		
	}
	
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false) Integer id)
	{
		List<Shipping> shippings=null;
		if(id==null)
		{
	        shippings=service.getAllShipping();
		 }
		else 
		{
			Shipping s=service.getOneShipping(id);
			shippings=Arrays.asList(s);
	     }
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingExcelView());
		m.addObject("list",shippings);
		return m;
	}
	
	@RequestMapping("/pdf")
	public  ModelAndView pdf(@RequestParam (required=false) Integer id)
	{
		List<Shipping> shippings=null;
		if(id==null)
		{
			shippings=service.getAllShipping();
		}
		else
		{
			shippings=Arrays.asList(service.getOneShipping(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingPdfView());
		m.addObject("list",shippings);
		return m;
	}

	@RequestMapping("/charts")
	public String genCharts()
	{
		List<Object[]> list=service.getShippingTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		return "ShippingPie";
	}

	

}
