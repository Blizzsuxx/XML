package com.clerk.clerkb.service.impl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clerk.clerkb.model.izvestajOImunizaciji.IzvestajOImunizaciji;
import com.clerk.clerkb.model.izvestajOImunizaciji.TDoza;
import com.clerk.clerkb.model.izvestajOImunizaciji.TProizvodjac;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.TVakcina;
import com.clerk.clerkb.repository.CertificateRequestRepository;
import com.clerk.clerkb.repository.DigitalCertificateRepository;
import com.clerk.clerkb.repository.ImmunizationRepository;
import com.clerk.clerkb.repository.InteresovanjeRepository;
import com.clerk.clerkb.repository.PotvrdaOVakcinacijiRepository;
import com.clerk.clerkb.service.IImmunizationService;

@Service
public class ImmunizationService implements IImmunizationService {

    @Autowired
    private ImmunizationRepository immunizationRepository;

    @Autowired
    private InteresovanjeRepository interesovanjeRepository;

    @Autowired
    private PotvrdaOVakcinacijiRepository potvrdaRepository;

    @Autowired
    private CertificateRequestRepository certificateRequestRepository;

    @Autowired
    private DigitalCertificateRepository digitalCertificateRepository;

    @Autowired
    private DocumentTransformerService transformerService;

    private static final String PATH_TO_XSL = "clerk-b/src/main/resources/xsl/";

    @Override
    public IzvestajOImunizaciji createImmunizationReport(String dateFrom, String dateUntil) {
        IzvestajOImunizaciji report = new IzvestajOImunizaciji();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(dateFrom, formatter);
        LocalDate date2 = LocalDate.parse(dateUntil, formatter);


        IzvestajOImunizaciji.IzvestajSeOdnosiNa fromTo = new IzvestajOImunizaciji.IzvestajSeOdnosiNa();
        ZonedDateTime dateTime = ZonedDateTime.now();
        GregorianCalendar c = GregorianCalendar.from(dateTime);
        XMLGregorianCalendar today = null;
        try {
            XMLGregorianCalendar from = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFrom);
            XMLGregorianCalendar until = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateUntil);
            today = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            fromTo.setDatumOd(from);
            fromTo.setDatumDo(until);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        //datumi
        report.setIzvestajSeOdnosiNa(fromTo);

        //podaci -> sta je sa sertifikatima?
        IzvestajOImunizaciji.Podaci podaci = new IzvestajOImunizaciji.Podaci();
        IzvestajOImunizaciji.Podaci.Imunizacija imunizacija = new IzvestajOImunizaciji.Podaci.Imunizacija();
        IzvestajOImunizaciji.Podaci.ZeleniSertifikat sertifikat = new IzvestajOImunizaciji.Podaci.ZeleniSertifikat();

        sertifikat.setPodneto(certificateRequestRepository.countForDates(date1, date2));
        sertifikat.setPrimljeno(digitalCertificateRepository.countForDates(date1, date2));

        imunizacija.setPodneto(interesovanjeRepository.countForDates(date1, date2));
        podaci.setImunizacija(imunizacija);
        podaci.setZeleniSertifikat(sertifikat);

        report.setPodaci(podaci);

        //datum izdavanja -> danas
        report.setDatumIzdavanja(today);

        //doze
        IzvestajOImunizaciji.PrimljeneDoze doze = new IzvestajOImunizaciji.PrimljeneDoze();
        List<TDoza> dozaList = new ArrayList<>();
        int cntOne = 0;
        int cntTwo = 0;
        for (PotvrdaOVakcinaciji potvrda: potvrdaRepository.findAll()) {
            LocalDate dateOne = potvrda.getDatumPrva().toGregorianCalendar().toZonedDateTime().toLocalDate();
            LocalDate dateTwo = potvrda.getDatumDruga().toGregorianCalendar().toZonedDateTime().toLocalDate();
            if(dateOne.isAfter(date1) && dateOne.isBefore(date2)){
                cntOne++;
            }
            if(dateTwo.isAfter(date1) && dateTwo.isBefore(date2)){
                cntTwo++;
            }
        }
        TDoza doza1 = new TDoza();
        doza1.setRedniBrojDoze(1L);
        doza1.setPrimljenaKolicina(cntOne);
        dozaList.add(doza1);

        TDoza doza2 = new TDoza();
        doza2.setRedniBrojDoze(2L);
        doza2.setPrimljenaKolicina(cntTwo);
        dozaList.add(doza2);

        doze.setDoza(dozaList);

        report.setPrimljeneDoze(doze);

        //proizvodjaci
        IzvestajOImunizaciji.Proizvodjaci proizvodjaci = new IzvestajOImunizaciji.Proizvodjaci();
        List<TProizvodjac> proizvodjacList = new ArrayList<>();
        int cntPfizer = 0;
        int cntSinopharm = 0;
        int cntSputnik = 0;
        int cntAZ = 0;
        int cntModerna = 0;
        for (PotvrdaOVakcinaciji potvrda: potvrdaRepository.findAll()) {
            LocalDate dateOne = potvrda.getDatumPrva().toGregorianCalendar().toZonedDateTime().toLocalDate();
            LocalDate dateTwo = potvrda.getDatumDruga().toGregorianCalendar().toZonedDateTime().toLocalDate();
            if(dateOne.isAfter(date1) && dateOne.isBefore(date2) || dateTwo.isAfter(date1) && dateTwo.isBefore(date2)){
                if(potvrda.getVakcina().getAstraZeneca() != null){
                    cntAZ++;
                }
                else if(potvrda.getVakcina().getModerna() != null){
                    cntModerna++;
                }
                else if(potvrda.getVakcina().getPfizer() != null){
                    cntPfizer++;
                }
                else if(potvrda.getVakcina().getSinopharm() != null){
                    cntSinopharm++;
                }
                else if(potvrda.getVakcina().getSputnik() != null){
                    cntSputnik++;
                }
            }
        }
        TProizvodjac proizvodjacAZ = new TProizvodjac();
        TVakcina az = new TVakcina();
        az.setAstraZeneca("Astra Zeneca");
        proizvodjacAZ.setIme(az);
        proizvodjacAZ.setBrojDoza(cntAZ);
        proizvodjacList.add(proizvodjacAZ);

        TProizvodjac proizvodjacModerna = new TProizvodjac();
        TVakcina moderna = new TVakcina();
        moderna.setModerna("Moderna");
        proizvodjacModerna.setIme(moderna);
        proizvodjacModerna.setBrojDoza(cntModerna);
        proizvodjacList.add(proizvodjacModerna);

        TProizvodjac proizvodjacPfizer = new TProizvodjac();
        TVakcina pfizer = new TVakcina();
        pfizer.setPfizer("Pfizer");
        proizvodjacPfizer.setIme(pfizer);
        proizvodjacPfizer.setBrojDoza(cntPfizer);
        proizvodjacList.add(proizvodjacPfizer);

        TProizvodjac proizvodjacSinopharm = new TProizvodjac();
        TVakcina sinopharm = new TVakcina();
        sinopharm.setSinopharm("Sinopharm");
        proizvodjacSinopharm.setIme(sinopharm);
        proizvodjacSinopharm.setBrojDoza(cntSinopharm);
        proizvodjacList.add(proizvodjacSinopharm);

        TProizvodjac proizvodjacSputnik = new TProizvodjac();
        TVakcina sputnik = new TVakcina();
        sputnik.setSputnik("Sputnik");
        proizvodjacSputnik.setIme(sputnik);
        proizvodjacSputnik.setBrojDoza(cntSputnik);
        proizvodjacList.add(proizvodjacSputnik);

        proizvodjaci.setProizvodjac(proizvodjacList);
        report.setProizvodjaci(proizvodjaci);

        //broj vakcina
        report.setDatoJeVakcina(cntAZ + cntModerna + cntPfizer + cntSinopharm + cntSputnik);
        String content = immunizationRepository.save(report);
        System.out.println(content);
        try {
            transformerService.generateHTML("izvestaj" + dateFrom + "t" + dateUntil, content, PATH_TO_XSL + "izvestaj_o_imunizaciji.xsl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return report;
    }
}
