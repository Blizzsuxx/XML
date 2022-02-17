package com.example.demo;

import com.example.demo.model.korisnik.Korisnik;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class KorisnikRepositoryTest {


    @Test
    public void testCreate() {
        Korisnik korisnik = new Korisnik();
        korisnik.setEmail("test@email.com");
        korisnik.setIme("testIme");
        korisnik.setPrezime("testPrezime");
        korisnik.setLozinka("testLozinka");

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
            System.out.println(xmlString);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
