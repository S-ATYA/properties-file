package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUser;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=whuser.pdf");
		@SuppressWarnings("unchecked")
		List<WhUser> user=(List<WhUser>) model.get("list");
		Paragraph p=new Paragraph("Welcome To WhUser type PDF View Page");
		doc.add(p);
		Paragraph p1=new Paragraph();
		doc.add(p1);
		PdfPTable table=new PdfPTable(9);
		table.addCell("ID");
		table.addCell("USER TYPE");
		table.addCell("USER CODE");
		table.addCell("USER FOR");
		table.addCell("EMAIL");
		table.addCell("CONTACT NUMBER");
		table.addCell("ID TYPE");
		table.addCell("OTHERS ID");
		table.addCell("ID NUMBER");
		for(WhUser u: user) {
			table.addCell(u.getId().toString());
			table.addCell(u.getIdType());
			table.addCell(u.getUserCode());
			table.addCell(u.getUserFor());
			table.addCell(u.getUserEmail());
			table.addCell(u.getMobileNumber());
			table.addCell(u.getIdType());
			table.addCell(u.getOthersId());
			table.addCell(u.getIdNumber());
		}
		doc.add(table);
		doc.add(new Paragraph(new Date().toString()));
	}

}
