package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Shipping;

public class ShippingExcelView extends AbstractXlsView{
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		resp.addHeader("Content-Disposition","attachment;filename=shippings.xls"); 
		
		List<Shipping> list=(List<Shipping>)model.get("list");
		
		Sheet sheet=book.createSheet("Shippings");
		
		addHeader(sheet);
		addBody(sheet,list);

	}

	private void addHeader(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("SHIPPING CODE");
		row.createCell(2).setCellValue("SHIPPING REF NO");
		row.createCell(3).setCellValue("COURIER REF NO");
		row.createCell(4).setCellValue("CONTACT DETAILS");
		row.createCell(5).setCellValue("SALE ORDER CODE");
		row.createCell(6).setCellValue("DESCRIPTION");
		row.createCell(7).setCellValue("BILL TO ADDRESS");
		row.createCell(8).setCellValue("SHIP TO ADDRESS");
	}

	private void addBody(Sheet sheet, List<Shipping> list) {
		
		int rowNum=1;
		for(Shipping s:list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getShippingCode());
			row.createCell(2).setCellValue(s.getRefNo());
			row.createCell(3).setCellValue(s.getCrefNo());
			row.createCell(4).setCellValue(s.getCdetails());
			row.createCell(5).setCellValue(s.getOrderCode());
			row.createCell(6).setCellValue(s.getDescription());
			row.createCell(7).setCellValue(s.getBillingAddress());
			row.createCell(8).setCellValue(s.getShippingAddress());
		}
		
	}


}
