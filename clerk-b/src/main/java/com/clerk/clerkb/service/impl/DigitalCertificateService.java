package com.clerk.clerkb.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.dto.EvidencijaDTO;
import com.clerk.clerkb.dto.Kolona;
import com.clerk.clerkb.jaxb.JaxB;
import com.clerk.clerkb.model.potvrdaOVakcinaciji.PotvrdaOVakcinaciji;
import com.clerk.clerkb.model.saglasnost.Dokument;
import com.clerk.clerkb.model.saglasnost.EvidencijaOVakcinaciji;
import com.clerk.clerkb.model.saglasnost.EvidencijaOVakcinaciji.ImePrezimeFaksimilBrtel;
import com.clerk.clerkb.model.saglasnost.EvidencijaOVakcinaciji.Tabela;
import com.clerk.clerkb.model.saglasnost.EvidencijaOVakcinaciji.Tabela.Element.Ekstremitet;
import com.clerk.clerkb.model.saglasnost.EvidencijaOVakcinaciji.Tabela.PrivremeneKontradikcije;
import com.clerk.clerkb.model.saglasnost.TIzbor;
import com.clerk.clerkb.model.saglasnost.TVakcina;
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
import com.ibm.icu.text.SimpleDateFormat;

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

    @Autowired
    private JaxB jaxB;

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
        String content = saglasnostRepository.findXmlById(id+".xml");
        System.out.println(content);
        transformerService.generateHTML("saglasnost" + id, content, PATH_TO_XSL + "obrazac_saglasnosti_za_imunizaciju.xsl");
        return "saglasnost" + id;
    }

    @Override
    public Dokument findSaglasnostByIdDocument(String id) throws FileNotFoundException, JAXBException {
        String content = saglasnostRepository.findXmlById(id+".xml");
        Dokument dokument = this.jaxB.unmarshall(Dokument.class, content);
        System.out.println(content);
        return dokument;
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
        String content = potvrdaRepository.findXmlById(id + ".xml");
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

    public Boolean dodajEvidenciju(EvidencijaDTO evidencija, String jmbg) throws Exception {
        System.out.println("Dodajem evidenciju za pacijenta sa jmbg: " + jmbg);
        Dokument dokument = this.findSaglasnostByIdDocument(jmbg);
        EvidencijaOVakcinaciji evidencijaOVakcinaciji = new EvidencijaOVakcinaciji();
        dokument.setEvidencijaOVakcinaciji(evidencijaOVakcinaciji);
        evidencijaOVakcinaciji.setVakcinacijskiPunkt(evidencija.punkt);
        evidencijaOVakcinaciji.setZdravstvenaUstanova(evidencija.institution);
        evidencijaOVakcinaciji.setImePrezimeFaksimilBrtel(new ImePrezimeFaksimilBrtel());
        evidencijaOVakcinaciji.getImePrezimeFaksimilBrtel().setIme(evidencija.name);
        evidencijaOVakcinaciji.getImePrezimeFaksimilBrtel().setPrezime(evidencija.lastname);
        evidencijaOVakcinaciji.getImePrezimeFaksimilBrtel().setFaksimil(evidencija.faksimil);
        evidencijaOVakcinaciji.getImePrezimeFaksimilBrtel().setBrtel(evidencija.telephone);
        evidencijaOVakcinaciji.setTabela(new Tabela());
        evidencijaOVakcinaciji.getTabela().setPrivremeneKontradikcije(new PrivremeneKontradikcije());
        evidencijaOVakcinaciji.getTabela().getPrivremeneKontradikcije().setDijagnoza(evidencija.privremeneKontradikcije);
        evidencijaOVakcinaciji.getTabela().setTrajneKontradikcije(new TIzbor());
        evidencijaOVakcinaciji.getTabela().getTrajneKontradikcije().setIzabran(evidencija.trajneKontradikcije);
        evidencijaOVakcinaciji.getTabela().setElement(new ArrayList<>());
        GregorianCalendar calendar = new GregorianCalendar();
        XMLGregorianCalendar date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(format.parse(evidencija.privremeneKontradikcijeDatum));
        date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        if(!evidencijaOVakcinaciji.getTabela().getPrivremeneKontradikcije().getDijagnoza().equals("")){

        evidencijaOVakcinaciji.getTabela().getPrivremeneKontradikcije().setDatum(date);// TODO
    }
        try{
            for (Kolona s : evidencija.tabela) {
                EvidencijaOVakcinaciji.Tabela.Element element = new EvidencijaOVakcinaciji.Tabela.Element();
                element.setSerija(Long.parseLong(s.serija));
                element.setPotpisLekara(s.potpisLekara);
                element.setNacinDavanja("ИМ");
                element.setEkstremitet(new Ekstremitet());
                element.setEkstremitet(s.ekstremitet);
                element.setNezeljenaReakcija(s.nezeljenaReakcija);
                element.setPotpisLekara(s.potpisLekara);
                element.setProizvodjac(new TVakcina());
                element.getProizvodjac().setVakcina(s.proizvodjac);
                element.setVakcina(new TVakcina());
                element.getVakcina().setVakcina(s.nazivVakcine);
                calendar.setTime(format.parse(s.datumVakcine));
                date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                element.setDatumDavanja(date);
                evidencijaOVakcinaciji.getTabela().getElement().add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        this.saglasnostRepository.save(dokument);

        return true;
    }

    


}
