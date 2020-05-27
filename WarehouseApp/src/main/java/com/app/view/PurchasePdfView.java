package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.app.model.Purchase;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchasePdfView extends AbstractPdfView {
	

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=purchases.pdf");
		Paragraph t=new Paragraph("hello all");
		document.add(t);
		@SuppressWarnings("unchecked")
		List<Purchase> purchases=(List<Purchase>) model.get("list");
	   PdfPTable table=new PdfPTable(4);
	   table.addCell("ID");
	   table.addCell("CODE");
	   table.addCell("MODE");
	
	   table.addCell("VENDOR");
	   table.addCell("REFERENCE NO");
	   table.addCell("QUALITY CHECK");
	   table.addCell("DESCRIPTION");
	   for(Purchase p:purchases)
	   {
		   table.addCell(p.getId().toString());
		   table.addCell(p.getOrderCode());
		   
		  
		   table.addCell(p.getQualityCheck());
		   table.addCell(p.getDefaultStatus());
		   table.addCell(p.getDescription());
	   }
	   document.add(table);
	   document.add(new Paragraph(new Date().toString()));
		

	}

}
