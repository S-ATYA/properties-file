package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUser;

public class WhUserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=whuser.xlsx");
		@SuppressWarnings("unchecked")
		List<WhUser> list=(List<WhUser>)model.get("list");
		Sheet sheet=book.createSheet("WhUser");
		addHeader(sheet);
		addBody(sheet,list);

	}

	private void addHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("User For");
		row.createCell(4).setCellValue("Email");
		row.createCell(5).setCellValue("Contact");
		row.createCell(6).setCellValue("ID TYPE");
		row.createCell(7).setCellValue("OTHERS ID");
		row.createCell(8).setCellValue("ID NUMBER");
	}
	private void addBody(Sheet sheet, List<WhUser> list) {
		int rowNum=1;
		for(WhUser w:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getIdType());
			row.createCell(2).setCellValue(w.getUserCode());
			row.createCell(3).setCellValue(w.getUserFor());
			row.createCell(4).setCellValue(w.getUserEmail());
			row.createCell(5).setCellValue(w.getMobileNumber());
			row.createCell(6).setCellValue(w.getIdType());
			row.createCell(7).setCellValue(w.getOthersId());
			row.createCell(8).setCellValue(w.getIdNumber());
		}

	}

}
