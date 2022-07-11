package com.clerk.clerkb.service;

import com.clerk.clerkb.dto.CitizenDocuments;
import com.clerk.clerkb.model.zahtevZaSertifikat.ZahteviZaSertifikat;
import com.clerk.clerkb.model.zeleniSertifikat.DigitalniSertifikat;

public interface IDigitalCertificateService {

    CitizenDocuments getDocumentsForCitizen(String citizenId);

    void declineCertificateRequest(String requestId, String reason) throws Exception;

    DigitalniSertifikat acceptCertificateRequest(String requestId) throws Exception;

    ZahteviZaSertifikat findAllRequests();

    String findRequestById(String id);
}
