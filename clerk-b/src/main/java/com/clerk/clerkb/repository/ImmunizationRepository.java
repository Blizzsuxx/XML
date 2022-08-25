package com.clerk.clerkb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.jaxb.JaxB;
import com.clerk.clerkb.model.izvestajOImunizaciji.IzvestajOImunizaciji;

@Repository
public class ImmunizationRepository {

    @Autowired
    private ExistManager existManager;
    
    @Autowired
    private JaxB jaxB;

    private final String collectionId = "db/reports";

    public String save(IzvestajOImunizaciji report){
        try {
            String xmlString = this.jaxB.marshall(IzvestajOImunizaciji.class, report);
            existManager.storeFromText(collectionId, report.getIzvestajSeOdnosiNa().getDatumOd().toString() + "t" + report.getIzvestajSeOdnosiNa().getDatumDo().toString() + ".xml", xmlString);
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
