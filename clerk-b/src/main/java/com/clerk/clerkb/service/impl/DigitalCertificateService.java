package com.clerk.clerkb.service.impl;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.repository.CertificateRequestRepository;
import com.clerk.clerkb.repository.PotvrdaOVakcinacijiRepository;
import com.clerk.clerkb.repository.SaglasnostRepository;
import com.clerk.clerkb.service.IDigitalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;

@Service
public class DigitalCertificateService implements IDigitalCertificateService {

    @Autowired
    private CertificateRequestRepository certificateRequestRepository;

    @Autowired
    private PotvrdaOVakcinacijiRepository potvrdaRepository;

    @Autowired
    private SaglasnostRepository saglasnostRepository;

    @Override
    public CitizenDocuments getDocumentsForCitizen(String citizenId) {
        CitizenDocuments cd = new CitizenDocuments();
        cd.setCertificateRequest(certificateRequestRepository.findById(citizenId));
        cd.setPotvrde(potvrdaRepository.findAllByJmbg(citizenId));
        cd.setSaglasnost(saglasnostRepository.findAllByCitizenId(citizenId));
        System.out.println(cd.getSaglasnost().get(0).getSaglasnostZaSprovodjenjeImunizacije());
        return cd;
    }
}
