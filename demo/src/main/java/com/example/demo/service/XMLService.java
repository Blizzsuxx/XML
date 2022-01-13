package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;

import com.example.demo.dto.XMLDto;
import com.example.demo.fuseki.FusekiReader;
import com.example.demo.jaxb.JaxB;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.example.demo.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.example.demo.model.zeleniSertifikat.DigitalniSertifikat;

import org.springframework.stereotype.Service;

@Service
public class XMLService {

    private final JaxB jaxB;

    public XMLService(JaxB jaxB) {
        this.jaxB = jaxB;
    }

   public String jaxBTestZahtevSertifikat(XMLDto dto) throws Exception {
       JAXBContext context = JAXBContext.newInstance(ZahtevZaSertifikat.class);

       ZahtevZaSertifikat zahtev = (ZahtevZaSertifikat) jaxB.unmarshall(ZahtevZaSertifikat.class, dto.getText());
       zahtev.setMesto("Novi Sad");
       System.out.println(zahtev);

       return jaxB.marshall(ZahtevZaSertifikat.class, zahtev);
   }

   public String jaxBInteresovanje(XMLDto dto) throws Exception {
       JAXBContext context = JAXBContext.newInstance(InteresovanjeZaVakcinisanje.class);

       InteresovanjeZaVakcinisanje interesovanje = (InteresovanjeZaVakcinisanje) jaxB.unmarshall(InteresovanjeZaVakcinisanje.class, dto.getText());
       interesovanje.setLokacija("Novi Sad");
       System.out.println(interesovanje);

       return jaxB.marshall(InteresovanjeZaVakcinisanje.class, interesovanje);
   }

   public String jaxBTestIzvestaj(XMLDto dto) throws Exception {
       JAXBContext context = JAXBContext.newInstance(IzvestajOImunizaciji.class);

       IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) jaxB.unmarshall(IzvestajOImunizaciji.class, dto.getText());
       izvestaj.setDatoJeVakcina(2l);
       System.out.println(izvestaj);

       return jaxB.marshall(IzvestajOImunizaciji.class, izvestaj);
   }

   public String jaxBTestPotvrda(XMLDto dto) throws Exception {
       JAXBContext context = JAXBContext.newInstance(PotvrdaOVakcinaciji.class);

       PotvrdaOVakcinaciji potvrda = (PotvrdaOVakcinaciji) jaxB.unmarshall(PotvrdaOVakcinaciji.class, dto.getText());
       potvrda.setQRCode("dakndkansfnajojfnaddfnas");
       System.out.println(potvrda);

       return jaxB.marshall(PotvrdaOVakcinaciji.class, potvrda);
   }

   public String jaxBTestSaglasnost(XMLDto dto) throws Exception {
       JAXBContext context = JAXBContext.newInstance(SaglasnostZaSprovodjenjeImunizacije.class);

       SaglasnostZaSprovodjenjeImunizacije saglasnost = (SaglasnostZaSprovodjenjeImunizacije) jaxB.unmarshall(SaglasnostZaSprovodjenjeImunizacije.class, dto.getText());
       saglasnost.setPotpis("gandas");
       System.out.println(saglasnost);

       return jaxB.marshall(DigitalniSertifikat.class, saglasnost);
   }

    public String jaxBTestZeleni(XMLDto dto) throws Exception {
    JAXBContext context = JAXBContext.newInstance(DigitalniSertifikat.class);

        DigitalniSertifikat sertifikat = (DigitalniSertifikat) jaxB.unmarshall(DigitalniSertifikat.class, dto.getText());
        sertifikat.setQRCode("dakndkansfnajojfnaddfnas");
        System.out.println(sertifikat);

    return jaxB.marshall(DigitalniSertifikat.class, sertifikat);
    }

    public ArrayList<String> searchByMetadata(String naziv, String godina) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("naziv", naziv);
        params.put("godina", godina);

        ArrayList<String> result = FusekiReader.executeQuery(params);
        return result;
    }
}
