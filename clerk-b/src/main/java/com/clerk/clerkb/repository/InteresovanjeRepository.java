package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InteresovanjeRepository {

    @Autowired
    private ExistManager existManager;

    private final String collectionId = "db/interesovanja";

    public int count(){
        return existManager.getCollectionCount(collectionId);
    }

    public long countForDates(LocalDate date1, LocalDate date2){
        List<InteresovanjeZaVakcinisanje> retVal = new ArrayList<>();

        try {
            ResourceSet xmlPotvrde = existManager.retrieve(collectionId, "/*");
            ResourceIterator i = xmlPotvrde.getIterator();
            XMLResource res;
            while(i.hasMoreResources()){
                try {
                    res = (XMLResource) i.nextResource();
                    JAXBContext jaxbContext = JAXBContext.newInstance(InteresovanjeZaVakcinisanje.class);
                    InteresovanjeZaVakcinisanje one = (InteresovanjeZaVakcinisanje) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
                    retVal.add(one);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long size = retVal.stream().filter(i -> i.getDan().toGregorianCalendar().toZonedDateTime().toLocalDate().isAfter(date1) &&
                i.getDan().toGregorianCalendar().toZonedDateTime().toLocalDate().isBefore(date2)).count();
        System.out.println("Interesovanja between dates: " + size);
        return size;
    }
}
