package com.example.demo.repository;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import com.example.demo.db.ExistManager;
import com.example.demo.model.korisnik.Korisnik;

@Repository
public class KorisnikRepository {

    @Autowired
    ExistManager existManager;

    private final String collectionId = "db/gradjanin/xml/korisnik";

    public boolean create(Korisnik korisnik) {
        try {
            JAXBContext context = JAXBContext.newInstance(Korisnik.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    " <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");

            StringWriter sw = new StringWriter();

            marshaller.marshal(korisnik, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(collectionId, korisnik.getEmail(), xmlString);
            existManager.storeFromText(collectionId, korisnik.getJmbg(), xmlString);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public XMLResource getOne(String email) throws Exception {
        return existManager.load(collectionId, email);
    }

}
