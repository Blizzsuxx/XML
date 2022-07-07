package com.clerk.clerkb.service.impl;

import com.clerk.clerkb.db.ExistManager;
import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahtevZaSertifikat;
import com.clerk.clerkb.repository.CertificateRequestRepository;
import com.clerk.clerkb.service.IDigitalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;

@Service
public class DigitalCertificateService implements IDigitalCertificateService {

    @Autowired
    private ExistManager existManager;

    @Autowired
    private CertificateRequestRepository certificateRequestRepository;

    @Override
    public CitizenDocuments getDocumentsForCitizen(String citizenId) {
        CitizenDocuments cd = new CitizenDocuments();
        cd.setCertificateRequest(certificateRequestRepository.findById(citizenId));
        return cd;
    }
}
