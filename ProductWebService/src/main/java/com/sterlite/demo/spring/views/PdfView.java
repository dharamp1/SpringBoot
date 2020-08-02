package com.sterlite.demo.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sterlite.demo.spring.entities.Product;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Component
public class PdfView extends MyAbstractPdfView {

	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 	response.setHeader("Content-Disposition", "attachment; filename=ProductDetails.pdf");
			// get model data from controller
			List<Product> products = (List<Product>) model.get("products");
			
			// Create pdf document
			PdfPTable table = new PdfPTable(4);
			table.addCell("Product Id");
			table.addCell("Name");
			table.addCell("Brand");
			table.addCell("Price");
			
			for(Product product : products) {
				PdfPCell productIdCell = new PdfPCell(new Phrase(product.getId().toString()));
				productIdCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				productIdCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(productIdCell);
				table.addCell(product.getName());
				table.addCell(product.getBrand());
				table.addCell(product.getPrice().toString());
			}
			document.add(table);
			document.close();
	}

}
