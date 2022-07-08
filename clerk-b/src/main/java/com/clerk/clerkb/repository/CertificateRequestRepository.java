package com.clerk.clerkb.repository;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;

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
}
