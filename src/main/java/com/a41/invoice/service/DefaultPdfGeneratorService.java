package com.a41.invoice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.ManagedBean;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.a41.invoice.order.model.Order;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Can Bayraktar
 *
 */
@ManagedBean
public class DefaultPdfGeneratorService{
	/*
	 * TODO : - decouple the service from raml schema definitions - remove the
	 * compilation phase here
	 */

	/**
	 * generating a pdf output stream from a template
	 * 
	 * @param templateData
	 */
	public StreamingOutput generate(Order order) {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				InputStream ips = getAndCreatePdfFileById(order);
				FileOutputStream outputStream = new FileOutputStream(new File("C:\\Calismalar\\pdf-"+order.getId()+".pdf"));

				int c;
				while ((c = ips.read()) != -1) {
					output.write(c);
					outputStream.write(c);
				}
				ips.close();
				outputStream.close();
			}
		};
	}

	private InputStream getAndCreatePdfFileById(Order order) {
		Document document = new Document();
		try {
			ByteArrayOutputStream ops = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, ops);
			document.open();
			Image image2 = Image.getInstance("C:\\Calismalar\\logo.png");
			document.add(image2);

			document.add(new Paragraph("All For One Steeb"));

			PdfPTable table = new PdfPTable(3); // 3 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			float[] columnWidths = { 1f, 1f, 1f };
			table.setWidths(columnWidths);

			PdfPCell cell1 = new PdfPCell(new Paragraph(order.getCustomer().getFirstName() + "" + order.getCustomer().getLastName()));
			// cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell2 = new PdfPCell(new Paragraph(order.getTotalPrice().toString()));
			// cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			PdfPCell cell3 = new PdfPCell(new Paragraph(order.getCurrency()));
			// cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);

			document.add(table);

			document.close();
			writer.close();
			return new ByteArrayInputStream(ops.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
