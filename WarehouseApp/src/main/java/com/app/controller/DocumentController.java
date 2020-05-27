package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	
	//1.calling show Document Register page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		List<Object[]> list=service.getDocumentIdAndName();
		map.addAttribute("list", list);
		return "Documents";
	}
	//2.uploading document method 
	@RequestMapping(value="/upload",method=POST)
	public String saveDoc(@RequestParam Integer fid,@RequestParam CommonsMultipartFile fdoc) {
		if (fdoc!=null) {
			Document doc=new Document();
			doc.setFileId(fid);
			doc.setFileName(fdoc.getOriginalFilename());
			doc.setFileData(fdoc.getBytes());
			service.saveDocument(doc);
		}
		
		//return "Document";
		return "redirect:register";
	}
	//3.download document method calling
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer fid,HttpServletResponse resp) {
		//read Object based on file id
		Document doc=service.getOneDocument(fid);
		//construct HttpResponse Head
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		//construct HttpResponse Body
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
