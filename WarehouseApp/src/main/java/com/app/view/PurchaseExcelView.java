package com.app.view;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import com.app.model.Purchase;

public class PurchaseExcelView extends AbstractXlsView{
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		resp.addHeader("Content-Disposition","attachment;filename=uoms.xls"); 
		
		@SuppressWarnings("unchecked")
		List<Purchase> list=(List<Purchase>)model.get("list");
		
		Sheet sheet=book.createSheet("Purchases");
		
		addHeader(sheet);
		addBody(sheet,list);

	}

	private void addHeader(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("MODE");
		row.createCell(3).setCellValue("VENDOR");
		row.createCell(4).setCellValue("REFERENCE NO");
		row.createCell(5).setCellValue("QUALITY CHECK");
		row.createCell(6).setCellValue("DEFAULT STATUS");
		row.createCell(7).setCellValue("DESCRIPTION");
	}

	private void addBody(Sheet sheet, List<Purchase> list) {
		
		int rowNum=1;
		for(Purchase p:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getId());
			row.createCell(1).setCellValue(p.getOrderCode());
			
			
			row.createCell(2).setCellValue(p.getQualityCheck());
			row.createCell(3).setCellValue(p.getDefaultStatus());
			row.createCell(4).setCellValue(p.getDescription());
		}
		
	}

}
