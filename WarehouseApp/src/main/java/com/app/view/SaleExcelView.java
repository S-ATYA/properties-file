package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Sale;

public class SaleExcelView extends AbstractXlsView {
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		resp.addHeader("Content-Disposition","attachment;filename=sales.xls"); 
		
		@SuppressWarnings("unchecked")
		List<Sale> list=(List<Sale>)model.get("list");
		
		Sheet sheet=book.createSheet("Sales");
		
		addHeader(sheet);
		addBody(sheet,list);

	}

	private void addHeader(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("MODE");
		row.createCell(3).setCellValue("CUSTOMER");
		row.createCell(4).setCellValue("REF NO");
		row.createCell(5).setCellValue("SMODE");
		row.createCell(6).setCellValue("SSOURCE");
		row.createCell(7).setCellValue("DESCRIPTION");
	}

	private void addBody(Sheet sheet, List<Sale> list) {
		
		int rowNum=1;
		for(Sale s:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getOrderCode());
			row.createCell(2).setCellValue(s.getShipmentMode());
			row.createCell(3).setCellValue(s.getCustomer());
			row.createCell(4).setCellValue(s.getReferenceNo());
			row.createCell(5).setCellValue(s.getStockMode());
			row.createCell(6).setCellValue(s.getStockSource());
			row.createCell(7).setCellValue(s.getDescription());
		}
		
	}


}
