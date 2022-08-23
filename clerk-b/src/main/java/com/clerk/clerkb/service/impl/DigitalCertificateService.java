package com.clerk.clerkb.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.TDoza;
import com.clerk.clerkb.model.zeleniSertifikat.TVakcinacija;
import com.clerk.clerkb.repository.CertificateRequestRepository;
import com.clerk.clerkb.repository.DigitalCertificateRepository;
import com.clerk.clerkb.repository.InteresovanjeRepository;
import com.clerk.clerkb.repository.PotvrdaOVakcinacijiRepository;
import com.clerk.clerkb.repository.SaglasnostRepository;
import com.clerk.clerkb.service.IDigitalCertificateService;
import com.google.zxing.WriterException;

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

    // @Autowired
    // private MailSender mailSender;

    //delete
    @Autowired
    private InteresovanjeRepository interesovanjeRepository;
    //

    @Autowired
    private DocumentTransformerService transformerService;

    private static final String PATH_TO_XSL = "clerk-b/src/main/resources/xsl/";

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

        digitalCert.setQrCode("http://localhost:8081/digitalcert" + id); //generate qrCode?

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

        String content = digitalCertificateRepository.save(digitalCert);

        generateCertificateView(id + "", content);
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
    public String findRequestById(String id) throws FileNotFoundException { //redefine ->d
        String content = certificateRequestRepository.findXmlById(id + ".xml");
        System.out.println(content);
        transformerService.generateHTML("request" + id, content, PATH_TO_XSL + "zahtev_za_sertifikat.xsl");
        return "request" + id + ".html";
    }

    @Override
    public String findSaglasnostById(String id) throws FileNotFoundException {
        String content = saglasnostRepository.findXmlById(id);
        System.out.println(content);
        transformerService.generateHTML("saglasnost" + id, content, PATH_TO_XSL + "obrazac_saglasnosti_za_imunizaciju.xsl");
        return "saglasnost" + id;
    }

    @Override
    public String generateCertificateView(String id, String content) throws IOException, WriterException {
//        System.out.println("Looking for certificate with id: " + id);
//        String content = digitalCertificateRepository.findXmlById(id);
//        System.out.println("Content: " + content);
        QRService.makeNewQr("http://localhost:8081/digitalcert" + id, "clerk-b/data/gen/qr-code" + id +".jpg");
        transformerService.generateHTML("digitalcert" + id, content, PATH_TO_XSL + "zeleni_sertifikat.xsl");
        return "digitalcert" + id;
    }

    

    @Override
    public String findPotvrdaById(String id) throws FileNotFoundException {
        String content = potvrdaRepository.findXmlById(id);
        transformerService.generateHTML("potvrda" + id, content, PATH_TO_XSL + "potvrda_o_vakcinaciji.xsl");
        return "potvrda" + id;
    }

    @Override
    public String findInteresovanje(String id) throws FileNotFoundException {
        String content = interesovanjeRepository.findXmlById(id);
        System.out.println(content);
        transformerService.generateHTML("interesovanje" + id, content, PATH_TO_XSL + "interesovanje.xsl");
        return "interesovanje" + id;
    }


}
