package com.clerk.clerkb.service.impl;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.TDoza;
import com.clerk.clerkb.model.zeleniSertifikat.TVakcinacija;
import com.clerk.clerkb.repository.*;
import com.clerk.clerkb.service.IDigitalCertificateService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

@Service
public class DigitalCertificateService implements IDigitalCertificateService {

    @Autowired
    private CertificateRequestRepository certificateRequestRepository;

    @Autowired
    private PotvrdaOVakcinacijiRepository potvrdaRepository;

    @Autowired
    private SaglasnostRepository saglasnostRepository;

    @Autowired
    private DigitalCertificateRepository digitalCertificateRepository;

    @Autowired
    private MailSender mailSender;

    //delete
    @Autowired
    private InteresovanjeRepository interesovanjeRepository;
    //

    @Autowired
    private DocumentTransformerService transformerService;

    private static final String PATH_TO_XSL = "src/main/resources/xsl/";

    @Override
    public CitizenDocuments getDocumentsForCitizen(String citizenId) {
        CitizenDocuments cd = new CitizenDocuments();
        cd.setCertificateRequest(certificateRequestRepository.findById(citizenId));
        cd.setPotvrde(potvrdaRepository.findAllByJmbg(citizenId));
        cd.setSaglasnost(saglasnostRepository.findAllByCitizenId(citizenId));
        System.out.println(cd.getSaglasnost().get(0).getSaglasnostZaSprovodjenjeImunizacije());
        return cd;
    }

    @Override
    public void declineCertificateRequest(String requestId, String reason) throws Exception {
        ZahtevZaSertifikat zs = certificateRequestRepository.findById(requestId);
        certificateRequestRepository.delete(requestId);
        //mailSender.sendDeclineRequestEmail(zs, reason);
    }

    @Override
    public DigitalniSertifikat acceptCertificateRequest(String requestId) throws Exception {
        ZahtevZaSertifikat zs = certificateRequestRepository.findById(requestId);
        DigitalniSertifikat digitalCert = new DigitalniSertifikat();
        digitalCert.setPacijent(zs.getPacijent());

        ZonedDateTime dateTime = ZonedDateTime.now();
        GregorianCalendar c = GregorianCalendar.from(dateTime);
        XMLGregorianCalendar today = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        digitalCert.setDatumIzdavanja(today);

        //get new id value;
        int id = digitalCertificateRepository.getIdForNewCertificate();
        digitalCert.setId(id);

        digitalCert.setQrCode("http://localhost:4200/certificate/" + id); //generate qrCode?

        digitalCert.setVreme(today);

        TVakcinacija vakcinacija = new TVakcinacija();
        List<TDoza> doze = new ArrayList<>();
        for (PotvrdaOVakcinaciji potvrda: potvrdaRepository.findAllByJmbg(zs.getPacijent().getJmbg())) {
            TDoza novaDoza = new TDoza();
            novaDoza.setInstitucija(potvrda.getUstanova().getNaziv());
            novaDoza.setDatum(potvrda.getDatumPrva().toString());
            novaDoza.setProizvodjac(potvrda.getVakcina().toString());
            novaDoza.setSerija(potvrda.getSerija());
            doze.add(novaDoza);
        }
        vakcinacija.setDoza(doze);
        digitalCert.setVakcinacija(vakcinacija);

        digitalCertificateRepository.save(digitalCert);

        //generate certificate html and pdf

        //mailSender.sendAcceptRequestEmail("digitalniSertifikat"); // + id
        return digitalCert;
    }

    @Override
    public ZahteviZaSertifikat findAllRequests() {
        ZahteviZaSertifikat zzs = new ZahteviZaSertifikat();
        List<ZahtevZaSertifikat> zzsList = certificateRequestRepository.findAll();

        zzs.setZahtev(zzsList);
        return zzs;
    }

    @Override
    public String findRequestById(String id) throws FileNotFoundException { //redefine
        String content = interesovanjeRepository.findXmlById(id);
        transformerService.generateHTML("interesovanje" + id, content, PATH_TO_XSL + "interesovanje.xsl");
        return "interesovanje" + id;
    }

    @Override
    public String generateCertificateView(String id) throws IOException, WriterException {
        String content = digitalCertificateRepository.findXmlById(id);
        QRService.makeNewQr("http://localhost:8081/sertifikat" + id, "data/gen/qr-code.jpg");
//        transformerService.generateHTML("digitalcert" + id, content, PATH_TO_XSL + "digitalniSertifikat.xsl"); //CHANGE
        return "digitalcert" + id;
    }


}
