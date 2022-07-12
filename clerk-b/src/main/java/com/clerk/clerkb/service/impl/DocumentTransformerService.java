package com.clerk.clerkb.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Service
public class DocumentTransformerService {

    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;

    static {
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        transformerFactory = TransformerFactory.newInstance();
    }

    public String generateHTML(String id, String content, String xslPath) throws FileNotFoundException {
        try{
            StreamSource transformSource = new StreamSource(new File(xslPath));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            Document d = null;
            try {
                d = documentFactory.newDocumentBuilder().parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
            } catch(SAXException | IOException | ParserConfigurationException e) {
                e.printStackTrace();
            }

            DOMSource source = new DOMSource(d);
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();

            StreamResult result = new StreamResult(bStream);
            transformer.transform(source, result);
            System.out.println(bStream.toString("UTF-8"));

            PrintWriter out = new PrintWriter("data/gen/" + id + ".html");
            out.println(bStream.toString("UTF-8"));
            out.flush();
            out.close();
            //?
            return  bStream.toString("UTF-8");
        } catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
