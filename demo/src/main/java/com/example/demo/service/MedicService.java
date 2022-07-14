package com.example.demo.service;

import com.example.demo.db.ExistManager;
import com.example.demo.model.saglasnost.Dokument;
import com.example.demo.model.saglasnost.EvidencijaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Service
public class MedicService {

    @Autowired
    private ExistManager existManager;

    private final String saglasnostiDb = "db/saglasnosti";


    public SaglasnostZaSprovodjenjeImunizacije findOneByJmbg(String email){

        try {
            XMLResource res = existManager.load(saglasnostiDb, email);
            JAXBContext jaxbContext = JAXBContext.newInstance(Dokument.class);
            Dokument cr = (Dokument) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
            return cr.getSaglasnostZaSprovodjenjeImunizacije();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Dokument addVaccineEvidenceToSaglasnost(String email, EvidencijaOVakcinaciji evidence){
        try {
            XMLResource res = existManager.load(saglasnostiDb, email);
            JAXBContext jaxbContext = JAXBContext.newInstance(Dokument.class);
            Dokument cr = (Dokument) jaxbContext.createUnmarshaller().unmarshal(res.getContentAsDOM());
            cr.setEvidencijaOVakcinaciji(evidence);
            save(cr);
            return cr;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void save(Dokument dokument){
        try {
            JAXBContext context = JAXBContext.newInstance(Dokument.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    " <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");

            StringWriter sw = new StringWriter();
            marshaller.marshal(dokument, sw);

            String xmlString = sw.toString();
            existManager.storeFromText(saglasnostiDb, dokument.getSaglasnostZaSprovodjenjeImunizacije().getOsoba().getEAdresa(), xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
