package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Shipment;

import com.app.service.IShipmentService;
import com.app.util.ShipmentUtils;
import com.app.view.ShipmentExcelView;
import com.app.view.ShipmentPdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
	@Autowired
	private IShipmentService service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentUtils util;
	
	@RequestMapping("/register")
	public String showReg(ModelMap map){
		map.addAttribute("shipmentType", new Shipment());
		return "ShipmentRegister";
	}
	@RequestMapping(value="/save", method=POST)
	public String saveShipment(@ModelAttribute Shipment s,ModelMap map) {
		Integer id=service.saveShipment(s);
		String message="Shipment '"+id+"' created SuccessFully ";
		map.addAttribute("shipmentType",new Shipment());
		map.addAttribute("msg", message);
		return "ShipmentRegister";
		
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Shipment> ships=service.getAllShipments();
		map.addAttribute("list", ships);
		
		return "ShipmentData";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer id,ModelMap map) {
		//call service layer
		service.deleteShipment(id);
		List<Shipment> uoms=service.getAllShipments();
		String message="'"+id+"'SuccessFully deleted";
		map.addAttribute("msg", message);
		map.addAttribute("list", uoms);
		return "ShipmentData";
	}
	
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		//call service
		Shipment ship=service.getOneShipment(id);
		map.addAttribute("ships", ship);
		return "ShipmentEdit";
	}
	@RequestMapping(value="/update", method=POST)
	public String update(@ModelAttribute Shipment shipmentType, ModelMap map) {
		//call service
		service.updateShipment(shipmentType);
		String message="'"+shipmentType.getId()+"' updated Successfully ";
		map.addAttribute("msg", message);
		List<Shipment> ships=service.getAllShipments();
		map.addAttribute("list", ships);
		return "ShipmentData";
	}
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id,ModelMap map) {
		Shipment ships=service.getOneShipment(id);
		map.addAttribute("ob", ships);
		return "ShipmentView";
	}
	//8 view excel
	@RequestMapping("/excel")
	public ModelAndView exportExcel(@RequestParam(required=false) Integer id) {
		List<Shipment> ships=null;
		if (id==null) {
			ships=service.getAllShipments();
		}else {
			Shipment ship=service.getOneShipment(id);
			ships=Arrays.asList(ship);
			
		}
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentExcelView());
		m.addObject("list", ships);
		return m;
	}
	//9 pdf view method
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(required=false) Integer id) {
		List<Shipment> ships=null;
		if (id==null) {
			ships=service.getAllShipments();
			
		}
		else {
			Shipment ship=service.getOneShipment(id);
			ships=Arrays.asList(ship);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentPdfView());
		m.addObject("list", ships);
		return m;
		
	}


}
