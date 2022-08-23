package com.clerk.clerkb.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.DocumentException;


/**
 * 
 * Primer demonstrira koriscenje iText PDF programskog API-a za 
 * renderovanje PDF-a na osnovu XML dokumenta. Alternativa Apache FOP-u.
 *
 */
@Service
public class PDFTransformer {
	
	private static DocumentBuilderFactory documentFactory;
	
	private static TransformerFactory transformerFactory;
	
	

	static {

		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);
		
		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
		
	}
 
    /**
     * Creates a PDF using iText Java API
     * @param filePath
     * @throws IOException
     * @throws DocumentException
     */
    public ByteArrayOutputStream generatePDF(String html) throws IOException, DocumentException {
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(html, bStream);

		return bStream;
        
    }

    public org.w3c.dom.Document buildDocument(String filePath) {

    	org.w3c.dom.Document document = null;
		try {
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			document = builder.parse(new File(filePath)); 

			if (document != null)
				System.out.println("[INFO] File parsed with no errors.");
			else
				System.out.println("[WARN] Document is null.");

		} catch (Exception e) {
			return null;
			
		} 

		return document;
	}
    
    public String generateHTML(String content, String xslPath) throws FileNotFoundException {
    	
		try {

			// Initialize Transformer instance
			StreamSource transformSource = new StreamSource(new File(xslPath));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			org.w3c.dom.Document d = null;
			try {
				d = documentFactory.newDocumentBuilder().parse(new ByteArrayInputStream(content.getBytes("UTF-8")));
			} catch (SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DOMSource source = new DOMSource(d);
			ByteArrayOutputStream bStream = new ByteArrayOutputStream();

			StreamResult result = new StreamResult(bStream);
			transformer.transform(source, result);
			return bStream.toString("UTF-8");
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    // public static void main(String[] args) throws IOException, DocumentException {

    // 	System.out.println("[INFO] " + PDFTransformer.class.getSimpleName());
    	
    // 	// Creates parent directory if necessary
    // 	File pdfFile = new File(OUTPUT_FILE);
    	
	// 	if (!pdfFile.getParentFile().exists()) {
	// 		System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
	// 		pdfFile.getParentFile().mkdir();
	// 	}
    	
	// 	PDFTransformer pdfTransformer = new PDFTransformer();
		
	// 	pdfTransformer.generateHTML(INPUT_FILE, XSL_FILE);
	// 	pdfTransformer.generatePDF(OUTPUT_FILE);
		
	// 	System.out.println("[INFO] File \"" + OUTPUT_FILE + "\" generated successfully.");
	// 	System.out.println("[INFO] End.");
    // }
    
}
