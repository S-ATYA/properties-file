package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Shipment;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachmant;filename=ships.pdf");
        Paragraph p=new Paragraph();
        document.add(p);
        List<Shipment> ship=(List<Shipment>)model.get("list");
        PdfPTable table=new PdfPTable(6);
        table.addCell("ID");
        table.addCell("SHIPMENT MODE");
        table.addCell("SHIPMENT CODE");
        table.addCell("ENABLE SHIPMENT");
        table.addCell("SHIPMENT GRADE");
        table.addCell("DESCRIPTION");
        for(Shipment s:ship)
        {
        	table.addCell(s.getId().toString());
        	table.addCell(s.getShipmentCode());
        	table.addCell(s.getShipmentCode());
        	table.addCell(s.getShipmentEnable());
        	table.addCell(s.getShipmentGrade());
        	table.addCell(s.getDescription());
        }
        document.add(table);
        document.add(new Paragraph(new Date().toString()));
        
	}

}
