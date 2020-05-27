package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Part;

import com.app.service.IOrderMethodService;
import com.app.service.IPartService;
import com.app.service.IUomService;
import com.app.util.CommonUtil;

@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService service;

	@Autowired
	private IUomService uomService;
	
	@Autowired
	private IOrderMethodService orderService;

	@RequestMapping("/register")
	public String showReq(ModelMap map)
	{
		map.addAttribute("part",new Part());
		List<Object[]> uomList=uomService.getUomTypeAndModels();
		Map<Integer,String> uoms=CommonUtil.convertData(uomList);
		map.addAttribute("uoms",uoms);
		
		List<Object[]> orderMethodList=orderService.getOrderMethodIdAndOrderCode();
		Map<Integer,String> orders=CommonUtil.convertData(orderMethodList);
		map.addAttribute("orders",orders);
		return "PartRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Part part,ModelMap map)
	{
		Integer id=service.savePart(part);
		String message="part '"+id+"' created";
		map.addAttribute("part",new Part());
		map.addAttribute("msg",message);
		return "PartRegister";
	}
	
}
