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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;




@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	@RequestMapping("/register")
	public String showReq(ModelMap map)
	{
		map.addAttribute("order",new OrderMethod());
		return "OrderMethodRegister";
	}
	@Autowired
	private ServletContext context;
	
	@Autowired
	private OrderMethodUtil util;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute OrderMethod ship,ModelMap map)
	{
		Integer id=service.saveOrderMethod(ship);
		String message="shipment '"+id+"' created";
		map.addAttribute("msg",message);
		map.addAttribute("order",new OrderMethod());
		return "OrderMethodRegister";
		
	}
	
	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<OrderMethod> ship=service.getAllOrderMethod();
		map.addAttribute("list",ship);
		return "OrderMethodData";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		service.deleteOrderMethod(id);
		List<OrderMethod> ship=service.getAllOrderMethod();
		String msg="Deleted '"+id+"' success fully";
		map.addAttribute("list",ship);
		map.addAttribute("msg",msg);
		return "OrderMethodData";
	}
	
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map)
	{
		OrderMethod od=service.getOneOrderMethod(id);
		map.addAttribute("ordermethod",od);
		return "OrderMethodEdit";
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute OrderMethod od,ModelMap map)
	{
		service.updateOrderMethod(od);
		String message="OrderMethod '"+od.getId()+"' update successfully";
		List<OrderMethod> method=service.getAllOrderMethod();
		map.addAttribute("list",method);
		return "OrderMethodData";
	}
	
	
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map)
	{
		OrderMethod od=service.getOneOrderMethod(id);
		map.addAttribute("ob",od);
		return "OrderMethodView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam (required=false)Integer id)
	{
		List<OrderMethod> order=null;
		if(id==null) {
		      order=service.getAllOrderMethod();
		      }
		else {
		OrderMethod orders=service.getOneOrderMethod(id);
		order=Arrays.asList(orders);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		m.addObject("list",order);
		return m;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(required=false) Integer id)
	{
		List<OrderMethod> order=null;
		if(id==null)
		{
			order=service.getAllOrderMethod();
		}else
		{
			order=Arrays.asList(service.getOneOrderMethod(id));
		}
		ModelAndView  m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		m.addObject("list",order);
		return m;
	}
	@RequestMapping("/charts")
	public String genCharts()
	{
		List<Object[]> list=service.getUomTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		return "OrderMethodPie";
	}
	
	
	
	
	
}
