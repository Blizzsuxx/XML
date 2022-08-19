package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Repository
public class ImmunizationRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/reports";

    public String save(IzvestajOImunizaciji report){
        try {
            JAXBContext context = JAXBContext.newInstance(IzvestajOImunizaciji.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    " <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");

            StringWriter sw = new StringWriter();
            marshaller.marshal(report, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(collectionId, report.getIzvestajSeOdnosiNa().getDatumOd().toString() + "t" + report.getIzvestajSeOdnosiNa().getDatumDo().toString() + ".xml", xmlString);
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
