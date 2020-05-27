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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private ServletContext context;

	@Autowired
	private UomUtil util;


	@Autowired
	private IUomService service;
	@RequestMapping("/register")
	public String showReq(ModelMap map)
	{
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom,ModelMap map)
	{
		Integer id=service.saveUom(uom);
		String message="uom '"+id+"' created";
		map.addAttribute("uom",new Uom());
		map.addAttribute("msg",message);
		return "UomRegister";

	}

	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<Uom> uoms=service.getAllUom();
		map.addAttribute("list",uoms);
		return "UomData";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map)
	{
		service.deleteUom(id);
		List<Uom> uom=service.getAllUom();
		String msg="Deleted '"+id+"' success fully";
		map.addAttribute("list",uom);
		map.addAttribute("msg",msg);
		return "UomData";
	}
	@RequestMapping("/edit")
	public String  showEdit(@RequestParam Integer id,ModelMap map)
	{
		Uom u=service.getOneUom(id);
		map.addAttribute("uom",u);
		return "UomEdit";

	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Uom uom,ModelMap map)
	{
		service.updateUom(uom);
		String message="UOM '"+uom.getId()+"'updated successfully";

		List<Uom> uoms=service.getAllUom();
		map.addAttribute("msg", message);
		map.addAttribute("list",uoms);
		return "UomData";
	}

	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map)
	{
		Uom uom=service.getOneUom(id);
		map.addAttribute("ob",uom);
		return "UomView";

	}

	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false) Integer id)
	{
		List<Uom> uoms=null;
		if(id==null)
		{
			uoms=service.getAllUom();
		}
		else 
		{
			Uom u=service.getOneUom(id);
			uoms=Arrays.asList(u);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		m.addObject("list",uoms);
		return m;
	}

	@RequestMapping("/pdf")
	public  ModelAndView pdf(@RequestParam (required=false) Integer id)
	{
		List<Uom> uoms=null;
		if(id==null)
		{
			uoms=service.getAllUom();
		}
		else
		{
			uoms=Arrays.asList(service.getOneUom(id));
		}
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("list",uoms);
		return m;
	}

	@RequestMapping("/charts")
	public String genCharts()
	{
		List<Object[]> list=service.getUomTypeAndCount();
		String path=context.getRealPath("/");
		util.genPie(path, list);
		return "UomPie";
	}
	
	@RequestMapping("/exist")
	public @ResponseBody String isModelExist(@RequestParam String uomModel)
	{
		String message="";
		boolean flag=service.isModelExist(uomModel);
		if(flag)
		{
			message="model'"+uomModel+"' already exist";
					
		}
		return message;
	}

}
