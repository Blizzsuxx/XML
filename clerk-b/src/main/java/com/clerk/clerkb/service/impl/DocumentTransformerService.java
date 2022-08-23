package com.clerk.clerkb.service.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;

import org.springframework.stereotype.Service;

import com.clerk.clerkb.service.PDFTransformer;

@Service
public class DocumentTransformerService {

    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;
    private PDFTransformer pdfTransformer;

    public DocumentTransformerService(PDFTransformer pdfTransformer) {
        this.pdfTransformer = pdfTransformer;
    }

    static {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        transformerFactory = TransformerFactory.newInstance();
    }

    public String generateHTML(String id, String content, String xslPath) throws FileNotFoundException {
        String html = this.pdfTransformer.generateHTML(content,
        xslPath);
        PrintWriter out = new PrintWriter("clerk-b/data/gen/" + id + ".html");
        out.println(html);
        out.flush();
        out.close();
        // ?
        return html;

    }
}
