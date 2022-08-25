package com.clerk.clerkb.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;

@Repository
public class CertificateRequestRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "/db/dokumenti/zahtevZaZeleniSertifikat";

    public ZahtevZaSertifikat findById(String citizenId){
        XMLResource res = null;
        try {
            res = existManager.load(collectionId, citizenId + ".xml");
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

    public String findXmlById(String citizenId){
        XMLResource res = null;
        try {
            res = existManager.load(collectionId, citizenId);
            if(res == null){
                return null;
            }
            return res.getContent().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String documentId) throws Exception {
        System.out.println(documentId);
        existManager.delete(collectionId, documentId);
    }

    public List<ZahtevZaSertifikat> findAll(){
        List<ZahtevZaSertifikat> retVal = new ArrayList<>();

        try{
            ResourceSet xmlRequests = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlRequests.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try{
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(ZahtevZaSertifikat.class);
                    
                    if(res == null || res.getId().contains(".xml")){
                        continue;
                    }
                    
                    ZahtevZaSertifikat one = (ZahtevZaSertifikat) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    String text = res.getContent().toString();
                    text = text.split("<razlog>")[1];
                    text = text.split("</razlog>")[0];
                    System.out.println("text");
                    System.out.println(text);
                    System.out.println("text");
                    one.setRazlog(text);
                    retVal.add(one);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return retVal;
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
