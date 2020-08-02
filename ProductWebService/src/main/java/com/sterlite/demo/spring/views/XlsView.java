package com.sterlite.demo.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.sterlite.demo.spring.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class XlsView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-Disposition", "attachment; filename=ProductDetails.xls");
		Sheet sheet = workbook.createSheet("Product Details");
		
		Row columnHeader = sheet.createRow(0);
		columnHeader.createCell(0).setCellValue("Product Id");
		columnHeader.createCell(1).setCellValue("Name");
		columnHeader.createCell(2).setCellValue("Brand");
		columnHeader.createCell(3).setCellValue("Price");
		
		
		List<Product> products = (List<Product>) model.get("products");
		
		int rowNo = 1;
		for(Product product: products) {
			Row rowData = sheet.createRow(rowNo);
			rowData.createCell(0).setCellValue(product.getId().toString());
			rowData.createCell(1).setCellValue(product.getName());
			rowData.createCell(2).setCellValue(product.getBrand());
			rowData.createCell(3).setCellValue(product.getPrice().toEngineeringString());
			rowNo++;
		}
	}

	

}
