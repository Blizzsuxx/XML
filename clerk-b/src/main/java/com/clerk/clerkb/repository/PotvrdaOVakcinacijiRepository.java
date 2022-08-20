package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PotvrdaOVakcinacijiRepository {
    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/potvrde";

    public List<PotvrdaOVakcinaciji> findAllByJmbg(String jmbg){
        List<PotvrdaOVakcinaciji> retVal = new ArrayList<>();

        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "//potvrdaOVakcinaciji"); //vraca sve potvrde -> xpath nece da vrati parenta
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(PotvrdaOVakcinaciji.class);
                    PotvrdaOVakcinaciji one = (PotvrdaOVakcinaciji) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retVal.stream().filter(p -> p.getPacijent().getJmbg().equals(jmbg)).collect(Collectors.toList());
    }

    public List<PotvrdaOVakcinaciji> findAll(){
        List<PotvrdaOVakcinaciji> retVal = new ArrayList<>();

        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "//potvrdaOVakcinaciji");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(PotvrdaOVakcinaciji.class);
                    PotvrdaOVakcinaciji one = (PotvrdaOVakcinaciji) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
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
}
