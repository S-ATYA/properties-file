package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Sale;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SalePdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=sales.pdf");
		Paragraph p=new Paragraph("hello all");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Sale> sales=(List<Sale>) model.get("list");
	   PdfPTable table=new PdfPTable(8);
	   table.addCell("ID");
	   table.addCell("CODE");
	   table.addCell("MODE");
	   table.addCell("CUSTOMER");
	   table.addCell("REF NO");
	   table.addCell("SMODE");
	   table.addCell("SSOURCE");
	   table.addCell("DESCRIPTION");
	   for(Sale s:sales)
	   {
		   table.addCell(s.getId().toString());
		   table.addCell(s.getOrderCode());
		   table.addCell(s.getShipmentMode());
		   table.addCell(s.getCustomer());
		   table.addCell(s.getReferenceNo());
		   table.addCell(s.getStockMode());
		   table.addCell(s.getStockSource());
		   table.addCell(s.getDescription());
	   }
	   document.add(table);
	   document.add(new Paragraph(new Date().toString()));
		

	}


}
