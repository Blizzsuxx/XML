package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CertificateRequestRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/requests";

    public ZahtevZaSertifikat findById(String citizenId){
        XMLResource res = null;
        try {
            res = existManager.load(collectionId, citizenId);
            if(res == null){
                return null;
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(ZahtevZaSertifikat.class);
            ZahtevZaSertifikat cr = (ZahtevZaSertifikat) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
            //System.out.println(res.getContent().toString());
            return cr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String documentId) throws Exception {
        System.out.println(documentId);
        existManager.delete(collectionId, documentId);
    }

    public long countForDates(LocalDate date1, LocalDate date2){
        List<ZahtevZaSertifikat> retVal = new ArrayList<>();

        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(ZahtevZaSertifikat.class);
                    ZahtevZaSertifikat one = (ZahtevZaSertifikat) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long size = retVal.stream().filter(cr -> cr.getDan().toGregorianCalendar().toZonedDateTime().toLocalDate().isAfter(date1) &&
                cr.getDan().toGregorianCalendar().toZonedDateTime().toLocalDate().isBefore(date2)).count();
        System.out.println("Requests between dates: " + size);
        return size;
    }
}
