package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Grn;


public class GrnExcelView extends AbstractXlsView{
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		resp.addHeader("Content-Disposition","attachment;filename=grns.xls"); 
		
		@SuppressWarnings("unchecked")
		List<Grn> list=(List<Grn>)model.get("list");
		
		Sheet sheet=book.createSheet("Grns");
		
		addHeader(sheet);
		addBody(sheet,list);

	}

	private void addHeader(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("TYPE");
		
		row.createCell(4).setCellValue("NOTE");
	}

	private void addBody(Sheet sheet, List<Grn> list) {
		
		int rowNum=1;
		for(Grn g:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(g.getId());
			row.createCell(1).setCellValue(g.getCode());
			row.createCell(2).setCellValue(g.getGrnType());
			
			row.createCell(4).setCellValue(g.getNote());
		}
		
	}

}
