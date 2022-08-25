package com.clerk.clerkb.repository;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.jaxb.JaxB;
import com.clerk.clerkb.model.saglasnost.Dokument;

@Repository
public class SaglasnostRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "/db/dokumenti/saglasnost";

    @Autowired
    private JaxB jaxB;

    public List<Dokument> findAllByCitizenId(String citizenId){
        List<Dokument> retVal = new ArrayList<>();
        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    //System.out.println(res.getContent().toString());
                    JAXBContext jaxbContext = JAXBContext.newInstance(Dokument.class);
                    Dokument one = (Dokument) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public List<Dokument> findAll(){
        List<Dokument> retVal = new ArrayList<>();
        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(Dokument.class);
                    Dokument one = (Dokument) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
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


    public String findXmlById(String id) {
        XMLResource res = null;
        try {
            res = existManager.load(collectionId, id);
            if(res == null){
                return null;
            }
            return res.getContent().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Dokument dokument) {
        String dokumentString = "";
        try {
            dokumentString = this.jaxB.marshall(Dokument.class, dokument);
        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            if(dokument.getSaglasnostZaSprovodjenjeImunizacije().getDrzavljanstvo().getRepublikaSrbija() != null){

                existManager.storeFromText(collectionId, dokument.getSaglasnostZaSprovodjenjeImunizacije().getDrzavljanstvo().getRepublikaSrbija().getJmbg() + ".xml", dokumentString);
        } else if(dokument.getSaglasnostZaSprovodjenjeImunizacije().getDrzavljanstvo().getStranac() != null) {

            existManager.storeFromText(collectionId, dokument.getSaglasnostZaSprovodjenjeImunizacije().getDrzavljanstvo().getStranac().getBrPasosaIliEbs() + ".xml", dokumentString);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
