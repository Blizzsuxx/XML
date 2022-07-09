package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.vakcina.Vaccine;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Repository
public class VaccineRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/vaccines";

    public Vaccine save(Vaccine vaccine){
        try {
            JAXBContext context = JAXBContext.newInstance(Vaccine.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(vaccine, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(collectionId, vaccine.getId() + ".xml", xmlString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vaccine;
    }

    public void updateQuantity(long vaccineId, int quantity){
        try{
            XMLResource resource = existManager.load(collectionId, vaccineId + ".xml");
            //System.out.println(res.getContent().toString());
            JAXBContext jaxbContext = JAXBContext.newInstance(Vaccine.class);
            Vaccine one = (Vaccine) jaxbContext.createUnmarshaller().unmarshal(resource.getContentAsDOM());
            one.setQuantity(quantity);

            JAXBContext context = JAXBContext.newInstance(Vaccine.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(one, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(collectionId, vaccineId + ".xml", xmlString);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Vaccine findById(long vaccineId){
        Vaccine vaccine = null;
        try {
            XMLResource resource = existManager.load(collectionId, vaccineId + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vaccine.class);
            vaccine = (Vaccine) jaxbContext.createUnmarshaller().unmarshal(resource.getContentAsDOM());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vaccine;
    }

}
