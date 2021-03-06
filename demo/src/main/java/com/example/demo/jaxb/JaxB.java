package com.example.demo.jaxb;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.example.demo.model.izvestajOImunizaciji.IzvestajOImunizaciji.Podaci.ZeleniSertifikat;
import com.example.demo.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.model.zahtevZaSertifikat.ZahtevZaSertifikat;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

@Component
public class JaxB {

    public <T> T unmarshall(Class genericClass, String text) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(this.getSchemaForClass(genericClass));
        unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        T createdObject = (T) unmarshaller.unmarshal(new StringReader(text));
        return createdObject;
    }

    public <T> String marshall(Class genericClass,T objecToMarshall) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(genericClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setSchema(this.getSchemaForClass(genericClass));
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(objecToMarshall, sw);
        return sw.toString();
    }

    public Schema getSchemaForClass(Class class1){
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = null;
        String filepath = "demo/src/main/resources/schemas/";
        if(class1.equals(InteresovanjeZaVakcinisanje.class)){
            filepath += "interesovanje.xsd";
        } else if(class1.equals(IzvestajOImunizaciji.class)){
            filepath += "izvestaj_o_imunizaciji.xsd";
            
        } else if(class1.equals(PotvrdaOVakcinaciji.class)){
            filepath += "potvrdaOVakcinaciji.xsd";
            
        } else if(class1.equals(SaglasnostZaSprovodjenjeImunizacije.class)){
            filepath += "saglasnost.xsd";
            
        } else if(class1.equals(ZahtevZaSertifikat.class)){
            filepath += "zahtevZaSertifikat.xsd";
            
        } else if(class1.equals(ZeleniSertifikat.class)){
            filepath += "zeleniSertifikat.xsd";
            
        }
		try {
            schema = sf.newSchema(new File(filepath));
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return schema;
    }

}