package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Shipping;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShippingPdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=shippings.pdf");
		Paragraph p=new Paragraph("hello all");
		document.add(p);
		List<Shipping> shippings=(List<Shipping>) model.get("list");
	   PdfPTable table=new PdfPTable(4);
	   table.addCell("ID");
	   table.addCell("SHIPPING CODE");
	   table.addCell("SHIPPING REF NO");
	   table.addCell("COURIER REF NO");
	   table.addCell("CONTACT DETAILS");
	   table.addCell("SALE ORDER CODE");
	   table.addCell("DESCRIPTION");
	   table.addCell("COURIER REF NO");
	   table.addCell("SHIP TO ADDRESS");
	   for(Shipping s:shippings)
	   {
		   table.addCell(s.getId().toString());
		   table.addCell(s.getShippingCode());
		   table.addCell(s.getRefNo());
		   table.addCell(s.getCrefNo());
		   table.addCell(s.getCdetails());
		   table.addCell(s.getOrderCode());
		   table.addCell(s.getDescription());
		   table.addCell(s.getBillingAddress());
		   table.addCell(s.getShippingAddress());
	   }
	   document.add(table);
	   document.add(new Paragraph(new Date().toString()));
		

	}

}
