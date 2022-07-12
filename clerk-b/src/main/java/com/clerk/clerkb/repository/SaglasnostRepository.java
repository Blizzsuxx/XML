package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.saglasnost.Dokument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaglasnostRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/saglasnosti";

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
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }
}
