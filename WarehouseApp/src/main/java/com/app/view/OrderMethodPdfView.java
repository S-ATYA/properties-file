package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition","attachment;filename=order.pdf");
		Paragraph p=new Paragraph("hello all");
		document.add(p);
		List<OrderMethod> orders=(List<OrderMethod>) model.get("list");
		   PdfPTable table=new PdfPTable(6);
		   table.addCell("ID");
		   table.addCell("ORDER MODE");
		   table.addCell("ORDER CODE");
		   table.addCell("ORDER TYPE");
		   table.addCell("DESCRIPTION");
		   table.addCell("ORDER ACCEPT");
		   for(OrderMethod o:orders)
		   {
			   table.addCell(o.getId().toString());
			   table.addCell(o.getOrderMode());
			   table.addCell(o.getOrderCode());
			   table.addCell(o.getOrderType());
			   table.addCell(o.getDescription());
			   table.addCell(o.getOrderAccept().toString());
		   }
		   document.add(table);
		   document.add(new Paragraph(new Date().toString()));
			
	}

}
