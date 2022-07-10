package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.example.demo.db.ExistManager;
import com.example.demo.dto.XMLDto;
import com.example.demo.fuseki.FusekiReader;
import com.example.demo.jaxb.JaxB;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.example.demo.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.example.demo.model.zeleniSertifikat.DigitalniSertifikat;

@Service
public class XMLService {

    private final JaxB jaxB;
    private final ExistManager existManager;
    private final MailSender mailSender;
    private final PDFTransformer pdfTransformer;

    public XMLService(JaxB jaxB, ExistManager existManager, MailSender mailSender, PDFTransformer pdfTransformer) {
        this.jaxB = jaxB;
        this.existManager = existManager;
        this.mailSender = mailSender;
        this.pdfTransformer = pdfTransformer;
    }

    public boolean podnesiZahtevZaSaglasnost(InteresovanjeZaVakcinisanje dto) {
        String interesovanjeZaVakcinisanje = null;
        GregorianCalendar calendar = new GregorianCalendar();
        Date trenutniDatum = new Date();
        calendar.setTime(trenutniDatum);
        dto.setGodina(calendar.get(Calendar.YEAR) % 10 + "");
        XMLGregorianCalendar date = null;
        try {

            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(DatatypeConstants.FIELD_UNDEFINED,
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                    DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        dto.setDan(date);
        try {
            interesovanjeZaVakcinisanje = this.jaxB.marshall(InteresovanjeZaVakcinisanje.class, dto);
            System.out.println(interesovanjeZaVakcinisanje);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            this.existManager.storeFromText("/db/dokumenti/zahtevZaSaglasnost", dto.getOsoba().getEAdresa() + ".xml",
                    interesovanjeZaVakcinisanje);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayOutputStream pdf = null;
        try {
            String html = this.pdfTransformer.generateHTML(interesovanjeZaVakcinisanje,
                    "demo/src/main/resources/xsl/interesovanje.xsl");
            this.existManager.storeFromText("/db/dokumenti/zahtevZaSaglasnost", dto.getOsoba().getEAdresa() + ".html",
            html);
            pdf = this.pdfTransformer.generatePDF(html);
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.mailSender.sendEmail(dto.getOsoba().getEAdresa(), pdf);
        return true;
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

        InteresovanjeZaVakcinisanje interesovanje = (InteresovanjeZaVakcinisanje) jaxB
                .unmarshall(InteresovanjeZaVakcinisanje.class, dto.getText());
        interesovanje.setLokacija("Novi Sad");
        System.out.println(interesovanje);

        return jaxB.marshall(InteresovanjeZaVakcinisanje.class, interesovanje);
    }

    public String jaxBTestIzvestaj(XMLDto dto) throws Exception {
        JAXBContext context = JAXBContext.newInstance(IzvestajOImunizaciji.class);

        IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) jaxB.unmarshall(IzvestajOImunizaciji.class,
                dto.getText());
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

        SaglasnostZaSprovodjenjeImunizacije saglasnost = (SaglasnostZaSprovodjenjeImunizacije) jaxB
                .unmarshall(SaglasnostZaSprovodjenjeImunizacije.class, dto.getText());
        saglasnost.setPotpis("gandas");
        System.out.println(saglasnost);

        return jaxB.marshall(DigitalniSertifikat.class, saglasnost);
    }

    public String jaxBTestZeleni(XMLDto dto) throws Exception {

        DigitalniSertifikat sertifikat = (DigitalniSertifikat) jaxB.unmarshall(DigitalniSertifikat.class,
                dto.getText());
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
