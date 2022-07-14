package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public long countForDates(LocalDate date1, LocalDate date2){
        List<DigitalniSertifikat> retVal = new ArrayList<>();

        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(DigitalniSertifikat.class);
                    DigitalniSertifikat one = (DigitalniSertifikat) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long size = retVal.stream().filter(dc -> dc.getDatumIzdavanja().toGregorianCalendar().toZonedDateTime().toLocalDate().isAfter(date1) &&
                dc.getDatumIzdavanja().toGregorianCalendar().toZonedDateTime().toLocalDate().isBefore(date2)).count();
        System.out.println("Certificates between dates: " + size);
        return size;
    }

    public String findXmlById(String id){
        XMLResource res = null;
        try {
            res = existManager.load(collectionId, id + ".xml");
            if(res == null){
                return null;
            }
            return res.getContent().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DigitalniSertifikat> findAll(){
        List<DigitalniSertifikat> retVal = new ArrayList<>();
        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(DigitalniSertifikat.class);
                    DigitalniSertifikat one = (DigitalniSertifikat) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }
}
