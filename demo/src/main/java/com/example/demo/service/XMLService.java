package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
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
import com.example.demo.dto.SaglasnostDTO;
import com.example.demo.dto.XMLDto;
import com.example.demo.dto.ZahtevZaSertifikatDTO;
import com.example.demo.fuseki.FusekiReader;
import com.example.demo.jaxb.JaxB;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.example.demo.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.RepublikaSrbija;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.Drzavljanstvo.Stranac;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.Izjava;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.RadniStatus;
import com.example.demo.model.saglasnost.SaglasnostZaSprovodjenjeImunizacije.Zanimanje;
import com.example.demo.model.saglasnost.TIzbor;
import com.example.demo.model.saglasnost.TOsoba;
import com.example.demo.model.saglasnost.TPol;
import com.example.demo.model.saglasnost.TVakcina;
import com.example.demo.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.example.demo.model.zeleniSertifikat.DigitalniSertifikat;
import com.ibm.icu.text.SimpleDateFormat;

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

    public Boolean podnesiSaglasnost(SaglasnostDTO dto) {
        SaglasnostZaSprovodjenjeImunizacije saglasnostZaSprovodjenjeImunizacije = new SaglasnostZaSprovodjenjeImunizacije();
        saglasnostZaSprovodjenjeImunizacije.setPotpis(dto.ime + " " + dto.prezime);
        saglasnostZaSprovodjenjeImunizacije.setIzjava( new Izjava());
        saglasnostZaSprovodjenjeImunizacije.getIzjava().setSaglasnost(new TIzbor());
        saglasnostZaSprovodjenjeImunizacije.getIzjava().getSaglasnost().setIzabran(dto.saglasnost);
        saglasnostZaSprovodjenjeImunizacije.getIzjava().setVakcina(new TVakcina());
        saglasnostZaSprovodjenjeImunizacije.getIzjava().getVakcina().setVakcina(dto.izabranaVakcina);
        saglasnostZaSprovodjenjeImunizacije.setDrzavljanstvo(new Drzavljanstvo());
        if(dto.drzavljanstvo.equals("Stranac")){
            saglasnostZaSprovodjenjeImunizacije.getDrzavljanstvo().setStranac( new Stranac());
            saglasnostZaSprovodjenjeImunizacije.getDrzavljanstvo().getStranac().setBrPasosaIliEbs(dto.jmbg);
            saglasnostZaSprovodjenjeImunizacije.getDrzavljanstvo().getStranac().setNazivStranogDrzavljanstva(dto.drzavljanstvo);
        } else {
            saglasnostZaSprovodjenjeImunizacije.getDrzavljanstvo().setRepublikaSrbija( new RepublikaSrbija());
            saglasnostZaSprovodjenjeImunizacije.getDrzavljanstvo().getRepublikaSrbija().setJmbg(dto.jmbg);
        }
        saglasnostZaSprovodjenjeImunizacije.setRadniStatus( new RadniStatus());
        saglasnostZaSprovodjenjeImunizacije.getRadniStatus().setRadniStatus(dto.radniStatus);
        saglasnostZaSprovodjenjeImunizacije.setZanimanje(new Zanimanje());
        saglasnostZaSprovodjenjeImunizacije.getZanimanje().setZanimanje(dto.zanimanje);
        saglasnostZaSprovodjenjeImunizacije.setKorisnikUstanoveSocZastite(new TIzbor());
        if(dto.socijalnaZastita.equals("Da")){
            saglasnostZaSprovodjenjeImunizacije.getKorisnikUstanoveSocZastite().setIzabran(true);
        } else {

            saglasnostZaSprovodjenjeImunizacije.getKorisnikUstanoveSocZastite().setIzabran(false);
        }
        saglasnostZaSprovodjenjeImunizacije.setOsoba( new TOsoba());
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setAdresa(dto.adresa);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setEAdresa(dto.eadresa);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setFiksni(dto.fiksni);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setIme(dto.ime);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setPrezime(dto.prezime);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setMesto(dto.mesto);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setMestoRodjenja(dto.mestoRodjenja);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setMobilni(dto.mobilni);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setImeRoditelja(dto.imeRoditelja);
        saglasnostZaSprovodjenjeImunizacije.getOsoba().setPol(new TPol());
        if(dto.pol.equals("Musko") || dto.pol.equals("Muski")){

            saglasnostZaSprovodjenjeImunizacije.getOsoba().getPol().setMusko("Musko");
        } else {

            saglasnostZaSprovodjenjeImunizacije.getOsoba().getPol().setMusko("Zensko");
        }
        
        
        GregorianCalendar calendar = new GregorianCalendar();
        Date trenutniDatum = new Date();
        calendar.setTime(trenutniDatum);
        
        XMLGregorianCalendar date = null;
        try {

            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        XMLGregorianCalendar rodjendan = null;
        try {
            calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse(dto.datumRodjenja));
        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {

            rodjendan = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        saglasnostZaSprovodjenjeImunizacije.getOsoba().setDatumRodjenja(rodjendan);
        saglasnostZaSprovodjenjeImunizacije.setDatum(date);
        String saglasnost = null;

        try {
            saglasnost = this.jaxB.marshall(SaglasnostZaSprovodjenjeImunizacije.class, saglasnostZaSprovodjenjeImunizacije);
            System.out.println(saglasnost);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            this.existManager.storeFromText("/db/dokumenti/saglasnost", dto.eadresa + ".xml",
            saglasnost);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // ByteArrayOutputStream pdf = null;
        // try {
        //     String html = this.pdfTransformer.generateHTML(interesovanjeZaVakcinisanje,
        //             "demo/src/main/resources/xsl/interesovanje.xsl");
        //     this.existManager.storeFromText("/db/dokumenti/zahtevZaSaglasnost", dto.getOsoba().getEAdresa() + ".html",
        //     html);
        //     pdf = this.pdfTransformer.generatePDF(html);
            
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // this.mailSender.sendEmail(dto.eadresa, pdf);
        return true;
    }

    public Boolean podnesiZahtevZaZeleniSertifikat(ZahtevZaSertifikatDTO dto) {
        ZahtevZaSertifikat zahtevZaSertifikat = new ZahtevZaSertifikat();
        zahtevZaSertifikat.setRazlog(dto.razlog);
        zahtevZaSertifikat.setPotpis(dto.ime + " " + dto.prezime);
        zahtevZaSertifikat.setMesto(dto.mesto);
        zahtevZaSertifikat.setPacijent(new com.example.demo.model.zahtevZaSertifikat.TOsoba());
        zahtevZaSertifikat.getPacijent().setIme(dto.ime);
        zahtevZaSertifikat.getPacijent().setPrezime(dto.prezime);
        zahtevZaSertifikat.getPacijent().setPasos(dto.brojPasossa);
        zahtevZaSertifikat.getPacijent().setJmbg(dto.jmbg);
        zahtevZaSertifikat.getPacijent().setPol(new com.example.demo.model.zahtevZaSertifikat.TPol());
        if(dto.pol.equals("Musko") || dto.pol.equals("Muski")){

            zahtevZaSertifikat.getPacijent().getPol().setMusko("Musko");
        } else {

            zahtevZaSertifikat.getPacijent().getPol().setMusko("Zensko");
        }
        
        
        
        GregorianCalendar calendar = new GregorianCalendar();
        Date trenutniDatum = new Date();
        calendar.setTime(trenutniDatum);
        
        XMLGregorianCalendar date = null;
        try {

            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        XMLGregorianCalendar rodjendan = null;
        try {
            calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse(dto.datumRodjenja));
        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {

            rodjendan = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        zahtevZaSertifikat.getPacijent().setDatum(rodjendan);
        try {
            zahtevZaSertifikat.setDan(DatatypeFactory.newInstance().newXMLGregorianCalendar());
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        zahtevZaSertifikat.getDan().setDay(date.getDay());

        try {
            zahtevZaSertifikat.setMesec(DatatypeFactory.newInstance().newXMLGregorianCalendar());
        } catch (DatatypeConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        zahtevZaSertifikat.getMesec().setMonth(date.getMonth());

        zahtevZaSertifikat.setGodina(date.getYear());
        String saglasnost = null;

        try {
            saglasnost = this.jaxB.marshall(ZahtevZaSertifikat.class, zahtevZaSertifikat);
            System.out.println(saglasnost);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            this.existManager.storeFromText("/db/dokumenti/zahtevZaZeleniSertifikat", dto.jmbg + ".xml",
            saglasnost);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // ByteArrayOutputStream pdf = null;
        // try {
        //     String html = this.pdfTransformer.generateHTML(interesovanjeZaVakcinisanje,
        //             "demo/src/main/resources/xsl/interesovanje.xsl");
        //     this.existManager.storeFromText("/db/dokumenti/zahtevZaSaglasnost", dto.getOsoba().getEAdresa() + ".html",
        //     html);
        //     pdf = this.pdfTransformer.generatePDF(html);
            
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // this.mailSender.sendEmail(dto.eadresa, pdf);
        return true;
    }
}
