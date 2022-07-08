package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Repository
public class DigitalCertificateRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/certificates";

    public int getIdForNewCertificate(){
        return existManager.getCollectionCount(collectionId) + 1;
    }

    public void save(DigitalniSertifikat digitalCertificate){
        try {
            JAXBContext context = JAXBContext.newInstance(DigitalniSertifikat.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    " <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");

            StringWriter sw = new StringWriter();
            marshaller.marshal(digitalCertificate, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(collectionId, digitalCertificate.getId().toString(), xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
