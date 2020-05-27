package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Shipment;

public class ShipmentExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
resp.addHeader("Content-Disposition","attachment;filename=shipment.xls"); 
		
		List<Shipment> list=(List<Shipment>)model.get("list");
		
		Sheet sheet=book.createSheet("Shipment");
		
		addHeader(sheet);
		addBody(sheet,list);
	}
		
		private void addHeader(Sheet sheet) {
			
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("SHIPMENT MODE");
			row.createCell(2).setCellValue("SHIPMENT CODE");
			row.createCell(3).setCellValue("SHIPMENT GRADE");
			row.createCell(4).setCellValue("ENABLE SHIPMENT");
			row.createCell(5).setCellValue("DESCRIPTION");
		}

		private void addBody(Sheet sheet, List<Shipment> list) {
			
			int rowNum=1;
			for(Shipment s:list)
			{
				Row row=sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(s.getId());
				row.createCell(1).setCellValue(s.getShipmentCode());
				row.createCell(2).setCellValue(s.getShipmentCode());
				row.createCell(3).setCellValue(s.getShipmentCode());
				row.createCell(4).setCellValue(s.getShipmentEnable());
				row.createCell(5).setCellValue(s.getDescription());
			}
			
		
	}

}
