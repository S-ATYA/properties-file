package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WhUser;
import com.app.service.IWhUserService;
import com.app.util.EmailUtil;
import com.app.view.WhUserPdfView;
import com.app.view.WhUserExcelView;

@Controller
@RequestMapping("/whuser")
public class WhUserController {

	@Autowired
	private IWhUserService service;
	@Autowired
	private EmailUtil emailUtil;

	//1.Register Page
	@RequestMapping("/register")
	public String showRegister(ModelMap map) {
		map.addAttribute("whUser", new WhUser());
		return "WhUserRegister";
	}
	//2.calling users save(insert into database ) method
	@RequestMapping(value="/save",method=POST)
	public String saveWhUserData(@ModelAttribute WhUser whUser,@RequestParam CommonsMultipartFile fileDoc,ModelMap map) {
		Integer id=service.saveWhUser(whUser);
		String message="User's'"+id+"' successfully created";
		//on save send email to user
		if (id!=null) {
			String text="Hello:"+whUser.getUserEmail()+"Your type is:"+whUser.getUserType()+", You can have "+whUser.getUserFor();
			boolean isSent=emailUtil.send(whUser.getUserEmail(), "Welcome to WareHouse App", text,fileDoc.getSize()!=0?fileDoc:null );
			if (isSent) {
				message+="Email sent";
			}else {
				message+="Email sending fail";
			}
		}
		map.addAttribute("msg", message);
		return "WhUserRegister";
	}

	//3.calling all data view page
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		//calling service
		List<WhUser> users=service.getAllWhUsers();
		map.addAttribute("list", users);
		return "WhUserData";
	}
	//4.calling getOneWhUser method 
	@RequestMapping("/view")
	public String getOne(@RequestParam Integer id, ModelMap map) {
		WhUser users=service.getOneWhUser(id);
		map.addAttribute("ob", users);
		return "WhUserView";
	}
	//5.edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id, ModelMap map) {
		WhUser users=service.getOneWhUser(id);
		map.addAttribute("whuser", users);
		return "WhUserEdit";
	}
	//6.updation method
	@RequestMapping(value ="/update", method=POST)
	public String  update(@ModelAttribute WhUser whUser,ModelMap map) {
		service.updateWhUser(whUser);
		String mesage="WHUSER '"+whUser.getId()+"' successfully updated";
		map.addAttribute("msg", mesage);
		List<WhUser> users=service.getAllWhUsers();
		map.addAttribute("list", users);
		return "WhUserData";
	}
	//7.calling delete method
	@RequestMapping("/delete")
	public String deleteOne(@RequestParam Integer id,ModelMap map) {
		service.deleteWhUser(id);
		List<WhUser> users=service.getAllWhUsers();
		String message=" WHUSER  '"+id+"' DELETED SUCCESSFULLY";
		map.addAttribute("list", users);
		map.addAttribute("msg", message);
		return "WhUserData";
	}
	//8 excel view
	@RequestMapping("/excel")
	public ModelAndView excelExport(@RequestParam(required=false) Integer id) {
		List<WhUser> users=null;
		if(id==null) {
			users=service.getAllWhUsers();
		}else {
			WhUser user=service.getOneWhUser(id);
			users=Arrays.asList(user);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserExcelView());
		m.addObject("list", users);

		return m;

	}
	//9 pdf view method
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(required=false) Integer id) {
		List<WhUser> users=null;
		if (id==null) {
			users=service.getAllWhUsers();
		}else {
			WhUser user =service.getOneWhUser(id);
			users=Arrays.asList(user);
		}
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserPdfView());
		m.addObject("list", users);
		return m;
	}
}	
